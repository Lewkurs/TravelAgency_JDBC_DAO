package DAOImplementations;

import DAO.HotelsDAO;
import Business_Aspects.Hotels;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelsDAOImpl implements HotelsDAO {

    private static final String INSERT_QUERY = "INSERT INTO hotels(hotel_name, address, destinations_id) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM hotels WHERE hotel_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM hotels";
    private static final String UPDATE_QUERY = "UPDATE hotels SET hotel_name=?, address=?, destinations_id=? WHERE hotel_id=?";
    private static final String DELETE_QUERY = "DELETE FROM hotels WHERE hotel_id = ?";

    private Connection connection;

    public HotelsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Hotels create(Hotels hotel) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, hotel.getHotelName());
            ps.setString(2, hotel.getAddress());
            ps.setInt(3, hotel.getDestinationsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    hotel.setHotelID(generatedKeys.getInt(1));
                }
                return hotel;
            }
        } catch (SQLException e) {
            System.out.println("Error creating hotel: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hotels getById(int hotelID) {
        Hotels hotel = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, hotelID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hotel = new Hotels();
                hotel.setHotelID(rs.getInt("hotel_id"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setDestinationsID(rs.getInt("destinations_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving hotel: " + e.getMessage());
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public List<Hotels> getAll() {
        List<Hotels> hotelList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hotels hotel = new Hotels();
                hotel.setHotelID(rs.getInt("hotel_id"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setDestinationsID(rs.getInt("destinations_id"));
                hotelList.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving hotels: " + e.getMessage());
            e.printStackTrace();
        }
        return hotelList;
    }

    @Override
    public Hotels update(Hotels hotel) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, hotel.getHotelName());
            ps.setString(2, hotel.getAddress());
            ps.setInt(3, hotel.getDestinationsID());
            ps.setInt(4, hotel.getHotelID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return hotel;
            }
        } catch (SQLException e) {
            System.out.println("Error updating hotel: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hotels delete(Hotels hotel) {
        return null;
    }

    @Override
    public int delete(int hotelID) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, hotelID);

            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row/s deleted.");
            if (rowsAffected > 0) {
                System.out.println("Hotel with ID: " + hotelID + " deleted successfully");
            } else {
                System.out.println("No hotel with ID: " + hotelID + " found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting hotel: " + e.getMessage());
            e.printStackTrace();
        }
        return hotelID;
    }
}