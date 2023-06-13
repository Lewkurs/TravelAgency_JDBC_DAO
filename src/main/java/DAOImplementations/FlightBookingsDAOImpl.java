package DAOImplementations;

import Business_Aspects.Bookings;
import DAO.FlightBookingsDAO;
import Business_Aspects.FlightBookings;
import Business_Aspects.Flights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingsDAOImpl implements FlightBookingsDAO {

    private static final String INSERT_QUERY = "INSERT INTO flight_bookings(flight_id, booking_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM flight_bookings WHERE booking_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM flight_bookings";
    private static final String DELETE_QUERY = "DELETE FROM flight_bookings WHERE booking_id = ?";

    private Connection connection;

    public FlightBookingsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public FlightBookings create(FlightBookings flightBookings) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, Flights.getFlightsID());
            ps.setInt(2, Bookings.getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return flightBookings;
            }
        } catch (SQLException e) {
            System.out.println("Error creating flight booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FlightBookings getById(int bookingID) {
        FlightBookings flightBooking = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, bookingID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                flightBooking = new FlightBookings();
                flightBooking.setFlightID(rs.getInt("flight_id"));
                flightBooking.setBookingID(rs.getInt("booking_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flight booking: " + e.getMessage());
            e.printStackTrace();
        }
        return flightBooking;
    }

    @Override
    public List<FlightBookings> getAll() {
        List<FlightBookings> flightBookingList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FlightBookings flightBooking = new FlightBookings();
                flightBooking.setFlightID(rs.getInt("flight_id"));
                flightBooking.setBookingID(rs.getInt("booking_id"));
                flightBookingList.add(flightBooking);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flight bookings: " + e.getMessage());
            e.printStackTrace();
        }
        return flightBookingList;
    }

    @Override
    public FlightBookings update(FlightBookings flightBooking) {
        return null;
    }

    @Override
    public FlightBookings delete(FlightBookings flightBooking) {
        return null;
    }

    public int delete(int bookingID) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, bookingID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            System.out.println("Error deleting flight booking: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}