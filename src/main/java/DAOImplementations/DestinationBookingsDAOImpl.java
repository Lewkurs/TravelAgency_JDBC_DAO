package DAOImplementations;

import Business_Aspects.*;
import DAO.ConnectionPool;
import DAO.DestinationBookingsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DestinationBookingsDAOImpl implements DestinationBookingsDAO {

    private static final String INSERT_QUERY = "INSERT INTO destination_bookings(destination_id, booking_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM destination_bookings WHERE destination_booking_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM destination_bookings";
    private static final String UPDATE_QUERY = "UPDATE destination_bookings SET destination_id = ?, booking_id = ? WHERE destination_booking_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM destination_bookings WHERE destination_booking_id = ?";

    private static final Logger logger = Logger.getLogger(DestinationBookingsDAOImpl.class.getName());

    private Connection connection;

    public DestinationBookingsDAOImpl() {
        // Establish a new connection or use a connection pool
        connection = ConnectionPool.getConnection();
    }

    @Override
    public DestinationBookings create(DestinationBookings destinationBooking) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, destinationBooking.getDestinationID().getDestinationsID());
            ps.setInt(2, destinationBooking.getBookingID().getBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    destinationBooking.setDestinationBookingID(generatedId);
                }
            }
        } catch (SQLException e) {
            logger.severe("Error creating destination booking: " + e.getMessage());
            e.printStackTrace();
        }
        return destinationBooking;
    }

    @Override
    public DestinationBookings getById(int bookingID) {
        DestinationBookings destinationBooking = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, bookingID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int destinationID = rs.getInt("destination_id");
                // Retrieve the corresponding Destinations and Bookings objects and set them
                Destinations destination = getDestinationByID(destinationID);
                Bookings booking = getBookingByID(bookingID);
                destinationBooking = new DestinationBookings(destination, booking);
                destinationBooking.setDestinationBookingID(rs.getInt("destination_booking_id"));
            }
        } catch (SQLException e) {
            logger.severe("Error retrieving destination booking: " + e.getMessage());
            e.printStackTrace();
        }
        return destinationBooking;
    }



    @Override
    public List<DestinationBookings> getAll() {
        List<DestinationBookings> destinationBookingsList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int destinationID = rs.getInt("destination_id");
                int bookingID = rs.getInt("booking_id");
                // Retrieve the corresponding Destinations and Bookings objects and set them
                Destinations destination = getDestinationByID(destinationID);
                Bookings booking = getBookingByID(bookingID);
                DestinationBookings destinationBooking = new DestinationBookings(destination, booking);
                destinationBooking.setDestinationBookingID(rs.getInt("destination_booking_id"));
                destinationBookingsList.add(destinationBooking);
            }
        } catch (SQLException e) {
            logger.info("Error retrieving destination bookings: " + e.getMessage());
            e.printStackTrace();
        }
        return destinationBookingsList;
    }

    @Override
    public DestinationBookings update(DestinationBookings destinationBooking) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setInt(1, destinationBooking.getDestinationID().getDestinationsID());
            ps.setInt(2, destinationBooking.getBookingID().getBookingID());
            ps.setInt(3, destinationBooking.getDestinationBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return destinationBooking;
            }
        } catch (SQLException e) {
            logger.severe("Error updating destination booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DestinationBookings delete(DestinationBookings destinationBooking) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, destinationBooking.getDestinationBookingID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return destinationBooking;
            }
        } catch (SQLException e) {
            logger.severe("Error deleting destination booking: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private Destinations getDestinationByID(int destinationID) {
        // Implement the retrieval of Destinations object by ID from the database or any other data source
        // Return the corresponding Destinations object
        return null;
    }

    private Bookings getBookingByID(int bookingID) {
        // Implement the retrieval of Bookings object by ID from the database or any other data source
        // Return the corresponding Bookings object
        return null;
    }
}
