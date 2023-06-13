package DAOImplementations;

import DAO.HotelBookingsDAO;
import Business_Aspects.HotelBookings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingsDAOImpl implements HotelBookingsDAO {

    private static final String INSERT_QUERY = "INSERT INTO hotel_bookings(hotel_id, booking_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM hotel_bookings WHERE booking_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM hotel_bookings";
    private static final String UPDATE_QUERY = "UPDATE hotel_bookings SET hotel_id=? WHERE booking_id=?";
    private static final String DELETE_QUERY = "DELETE FROM hotel_bookings WHERE booking_id = ?";

    private Connection connection;

    public HotelBookingsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public HotelBookings create(HotelBookings hotelBooking) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, hotelBooking.getHotelID().getHotelsID());
            ps.setInt(2, hotelBooking.getBookingID().getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return hotelBooking;
            }
        } catch (SQLException e) {
            System.out.println("Error creating hotel booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HotelBookings getById(int bookingID) {
        HotelBookings hotelBooking = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, bookingID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hotelBooking = new HotelBookings();
                hotelBooking.setHotelID(rs.getObject("hotel_id"));
                hotelBooking.setBookingID(rs.getInt("booking_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving hotel booking: " + e.getMessage());
            e.printStackTrace();
        }
        return hotelBooking;
    }

    @Override
    public List<HotelBookings> getAll() {
        List<HotelBookings> hotelBookingList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HotelBookings hotelBooking = new HotelBookings();
                hotelBooking.setHotelID(rs.getInt("hotel_id"));
                hotelBooking.setBookingID(rs.getInt("booking_id"));
                hotelBookingList.add(hotelBooking);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving hotel bookings: " + e.getMessage());
            e.printStackTrace();
        }
        return hotelBookingList;
    }

    @Override
    public HotelBookings update(HotelBookings hotelBooking) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setInt(1, hotelBooking.getHotelID());
            ps.setInt(2, hotelBooking.getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return hotelBooking;
            }
        } catch (SQLException e) {
            System.out.println("Error updating hotel booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HotelBookings delete(HotelBookings hotelBooking) {
        return null;
    }

    @Override
    public int delete(int bookingID) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, bookingID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            System.out.println("Error deleting hotel booking: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}
