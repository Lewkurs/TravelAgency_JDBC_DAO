package DAOImplementations;

import Business_Aspects.Hotels;
import DAO.RoomsDAO;
import Business_Aspects.Rooms;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAOImpl implements RoomsDAO {

    private static final String INSERT_QUERY = "INSERT INTO rooms(room_type, price_per_night, availability, hotel_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM rooms WHERE room_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM rooms";
    private static final String UPDATE_QUERY = "UPDATE rooms SET room_type = ?, price_per_night = ?, availability = ?, hotel_id = ? WHERE room_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM rooms WHERE room_id = ?";

    private Connection connection;

    public RoomsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Rooms create(Rooms room) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, room.getRoomType());
            ps.setDouble(2, room.getPricePerNight());
            ps.setBoolean(3, room.isAvailability());
            ps.setInt(4, room.getHotelID().getHotelsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    room.setRoomsID(generatedKeys.getInt(1));
                    return room;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating room: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Rooms getById(int roomID) {
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, roomID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Rooms room = new Rooms();
                room.setRoomsID(rs.getInt("room_id"));
                room.setRoomType(rs.getString("room_type"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setAvailability(rs.getBoolean("availability"));

                Hotels hotel = new Hotels();
                hotel.setHotelsID(rs.getInt("hotel_id"));
                room.setHotelID(hotel);

                return room;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving room: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rooms> getAll() {
        List<Rooms> roomsList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rooms room = new Rooms();
                room.setRoomsID(rs.getInt("room_id"));
                room.setRoomType(rs.getString("room_type"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setAvailability(rs.getBoolean("availability"));

                Hotels hotel = new Hotels();
                hotel.setHotelsID(rs.getInt("hotel_id"));
                room.setHotelID(hotel);

                roomsList.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving rooms: " + e.getMessage());
            e.printStackTrace();
        }
        return roomsList;
    }

    @Override
    public Rooms update(Rooms room) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, room.getRoomType());
            ps.setDouble(2, room.getPricePerNight());
            ps.setBoolean(3, room.isAvailability());
            ps.setInt(4, room.getHotelID().getHotelsID());
            ps.setInt(5, room.getRoomsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return room;
            }
        } catch (SQLException e) {
            System.out.println("Error updating room: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Rooms delete(Rooms room) {
        int roomID = room.getRoomsID();
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, roomID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Room with ID: " + roomID + " deleted successfully");
            } else {
                System.out.println("No Room with ID: " + roomID + " found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting room: " + e.getMessage());
            e.printStackTrace();
        }
        return room;
    }
}
