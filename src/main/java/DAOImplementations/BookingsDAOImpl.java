package DAOImplementations;

import Business_Aspects.*;
import DAO.BookingsDAO;
import DAO.ConnectionPool;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingsDAOImpl implements BookingsDAO {
    private final SqlSession sqlSession;

    public BookingsDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    private ResultSet rs = null;
    private static final Logger logger = Logger.getLogger(BookingsDAOImpl.class.getName());

    public Bookings create(Bookings booking) {
        String query = "INSERT INTO bookings(booking_date, total_cost, customer_id, payment_id, flight_id, hotel_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, booking.getBookingDate());
            ps.setDouble(2, booking.getTotalCost());
            ps.setInt(3, booking.getCustomerID().getCustomerID());
            ps.setInt(4, booking.getPaymentID().getPaymentsID());
            ps.setInt(5, booking.getFlightID().getFlightsID());
            ps.setInt(6, booking.getHotelID().getHotelsID());

            // Execute the query
            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating booking: " + e.getMessage(), e);
        }
        return booking;
    }

    public Bookings getById(int bookingID) {
        String query = "SELECT * FROM bookings WHERE booking_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, bookingID);
            // Execute the query
            rs = ps.executeQuery();

            if (rs.next()) {
                // Create and return the booking object
                return getBookingFromResultSet(rs);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving booking: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Bookings> getAll() {
        List<Bookings> bookingList = new ArrayList<>();
        String query = "SELECT * FROM bookings";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {

            // Execute the query
            rs = st.executeQuery();

            while (rs.next()) {
                // Create a booking object for each row and add it to the list
                Bookings booking = getBookingFromResultSet(rs);
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving bookings: " + e.getMessage(), e);
        }
        return bookingList;
    }


    public Bookings update(Bookings booking) {
        String query = "UPDATE bookings SET booking_date = ?, total_cost = ?, customer_id = ?, payment_id = ?, flight_id = ?, hotel_id = ? WHERE booking_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, booking.getBookingDate());
            ps.setDouble(2, booking.getTotalCost());
            ps.setInt(3, booking.getCustomerID().getCustomerID());
            ps.setInt(4, booking.getPaymentID().getPaymentsID());
            ps.setInt(5, booking.getFlightID().getFlightsID());
            ps.setInt(6, booking.getHotelID().getHotelsID());
            ps.setInt(7, booking.getBookingID());

            // Execute the query
            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating booking: " + e.getMessage(), e);
        }
        return booking;
    }

    @Override
    public Bookings delete(Bookings booking) {
        return null;
    }

    public Bookings delete(int bookingID) {
        String query = "DELETE FROM bookings WHERE booking_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, bookingID);

            // Execute the query
            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, rowsAffected + " row(s) deleted.");

            if (rowsAffected > 0) {
                logger.log(Level.INFO, "Booking with ID: " + bookingID + " deleted successfully");
            } else {
                logger.log(Level.INFO, "No booking with ID: " + bookingID + " found");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting booking: " + e.getMessage(), e);
        }
        return null;
    }

    private Bookings getBookingFromResultSet(ResultSet rs) throws SQLException {
        Bookings booking = new Bookings();
        booking.setBookingID(rs.getInt("booking_id"));
        booking.setBookingDate(rs.getString("booking_date"));
        booking.setTotalCost(rs.getDouble("total_cost"));

        Customers customer = new Customers();
        customer.setCustomerID(rs.getInt("customer_id"));

        Payments payment = new Payments();
        payment.setPaymentsID(rs.getInt("payment_id"));

        Flights flight = new Flights();
        flight.setFlightsID(rs.getInt("flight_id"));

        Hotels hotel = new Hotels();
        hotel.setHotelsID(rs.getInt("hotel_id"));

        booking.setCustomerID(customer);
        booking.setPaymentID(payment);
        booking.setFlightID(flight);
        booking.setHotelID(hotel);

        return booking;
    }
}
