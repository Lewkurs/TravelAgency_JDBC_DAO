package DAOImplementations;

import DAO.ConnectionPool;
import DAO.HotelBookingsDAO;
import Business_Aspects.HotelBookings;
import Business_Aspects.Hotels;
import Business_Aspects.Bookings;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HotelBookingsDAOImpl implements HotelBookingsDAO {

    private static final String INSERT_QUERY = "INSERT INTO hotel_bookings(hotel_id, booking_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM hotel_bookings WHERE booking_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM hotel_bookings";
    private static final String UPDATE_QUERY = "UPDATE hotel_bookings SET hotel_id=? WHERE booking_id=?";
    private static final String DELETE_QUERY = "DELETE FROM hotel_bookings WHERE booking_id = ?";

    private static final Logger logger = Logger.getLogger(HotelBookingsDAOImpl.class.getName());

    private Connection connection;

    public HotelBookingsDAOImpl() {
        // Establish a new connection or use a connection pool
        connection = ConnectionPool.getConnection();
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
            logger.severe("Error creating hotel booking: " + e.getMessage());
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
                int hotelID = rs.getInt("hotel_id");
                Hotels hotel = getHotelByID(hotelID);
                Bookings booking = getBookingByID(bookingID);
                hotelBooking = new HotelBookings(hotel, booking);
                hotelBooking.setBookingID(booking);
            }
        } catch (SQLException e) {
            logger.severe("Error retrieving hotel booking: " + e.getMessage());
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
                int hotelID = rs.getInt("hotel_id");
                Hotels hotel = getHotelByID(hotelID);
                Bookings booking = getBookingByID(rs.getInt("booking_id"));
                HotelBookings hotelBooking = new HotelBookings(hotel, booking);
                hotelBookingList.add(hotelBooking);
            }
        } catch (SQLException e) {
            logger.info("Error retrieving hotel bookings: " + e.getMessage());
            e.printStackTrace();
        }
        return hotelBookingList;
    }

    @Override
    public HotelBookings update(HotelBookings hotelBooking) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setInt(1, hotelBooking.getHotelID().getHotelsID());
            ps.setInt(2, hotelBooking.getBookingID().getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return hotelBooking;
            }
        } catch (SQLException e) {
            logger.severe("Error updating hotel booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HotelBookings delete(HotelBookings hotelBooking) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, hotelBooking.getBookingID().getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return hotelBooking;
            }
        } catch (SQLException e) {
            logger.severe("Error deleting hotel booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private Hotels getHotelByID(int hotelID) {
        HotelBookingsDAO hotelBookingsDAO = new HotelBookingsDAOImpl();
        return hotelBookingsDAO.getById(hotelID).getHotelID();
    }

    private Bookings getBookingByID(int bookingID) {
        HotelBookingsDAO hotelBookingsDAO = new HotelBookingsDAOImpl();
        return hotelBookingsDAO.getById(bookingID).getBookingID();
    }
}
