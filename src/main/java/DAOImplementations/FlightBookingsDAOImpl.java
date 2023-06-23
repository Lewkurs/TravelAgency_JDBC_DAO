package DAOImplementations;

import Business_Aspects.Bookings;
import DAO.BookingsDAO;
import Business_Aspects.FlightBookings;
import Business_Aspects.Flights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingsDAOImpl implements BookingsDAO {

    private static final String INSERT_QUERY = "INSERT INTO flight_bookings(flight_id, booking_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM flight_bookings WHERE booking_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM flight_bookings";
    private static final String DELETE_QUERY = "DELETE FROM flight_bookings WHERE booking_id = ?";

    private Connection connection;

    public FlightBookingsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Bookings create(Bookings booking) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, booking.getFlightID().getFlightsID());
            ps.setInt(2, booking.getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return booking;
            }
        } catch (SQLException e) {
            System.out.println("Error creating flight booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bookings getById(int bookingID) {
        Bookings booking = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, bookingID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int flightID = rs.getInt("flight_id");
                int retrievedBookingID = rs.getInt("booking_id");

                // Retrieve the Flights objects corresponding to the flight ID
                List<Flights> flights = getFlightsByID(flightID);

                // Create the Bookings object
                booking = new Bookings();
                booking.setBookingID(retrievedBookingID);
                booking.setFlightID(flights.get(0));

            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flight booking: " + e.getMessage());
            e.printStackTrace();
        }
        return booking;
    }

    @Override
    public List<Bookings> getAll() {
        List<Bookings> bookingList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bookings booking = new Bookings();
                int flightID = rs.getInt("flight_id");
                int bookingID = rs.getInt("booking_id");

                // Retrieve the Flights objects corresponding to the flight ID
                List<Flights> flights = getFlightsByID(flightID);

                // Set the retrieved details in the Bookings object
                booking.setBookingID(bookingID);
                booking.setFlightID(flights.get(0));


                bookingList.add(booking);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flight bookings: " + e.getMessage());
            e.printStackTrace();
        }
        return bookingList;
    }

    @Override
    public Bookings update(Bookings booking) {
        // TODO: Implement update logic
        return null;
    }

    @Override
    public Bookings delete(Bookings bookings) {
        return null;
    }

    @Override
    public Bookings delete(int bookingID) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, bookingID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                Bookings deletedBooking = new Bookings();
                deletedBooking.setBookingID(bookingID);
                return deletedBooking;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting flight booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private List<Flights> getFlightsByID(int flightID) {
        List<Flights> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE flight_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, flightID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String airline = rs.getString("airline");
                String departureCity = rs.getString("departure_city");
                String arrivalCity = rs.getString("arrival_city");
                String departureTime = rs.getString("departure_time");
                String arrivalTime = rs.getString("arrival_time");

                Flights flight = new Flights();
                flight.setFlightsID(flightID);
                flight.setAirline(airline);
                flight.setDepartureCity(departureCity);
                flight.setArrivalCity(arrivalCity);
                flight.setDepartureTime(departureTime);
                flight.setArrivalTime(arrivalTime);

                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flights: " + e.getMessage());
            e.printStackTrace();
        }
        return flights;
    }
}
