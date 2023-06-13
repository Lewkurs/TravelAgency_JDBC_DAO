package DAOImplementations;

import Business_Aspects.Destinations;
import DAO.TransportationDAO;
import Business_Aspects.Transportation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportationDAOImpl implements TransportationDAO {

    private static final String INSERT_QUERY = "INSERT INTO transportation(transportation_type, description, price_per_hour, destination_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM transportation WHERE transportation_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM transportation";
    private static final String UPDATE_QUERY = "UPDATE transportation SET transportation_type = ?, description = ?, price_per_hour = ?, destination_id = ? WHERE transportation_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM transportation WHERE transportation_id = ?";

    private Connection connection;

    public TransportationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Transportation create(Transportation transportation) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, transportation.getTransportationType());
            ps.setString(2, transportation.getDescription());
            ps.setDouble(3, transportation.getPricePerHour());
            ps.setInt(4, transportation.getDestinationID().getDestinationsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    transportation.setTransportationID(generatedKeys.getInt(1));
                    return transportation;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating transportation: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Transportation getById(int transportationID) {
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, transportationID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Transportation transportation = new Transportation();
                transportation.setTransportationID(rs.getInt("transportation_id"));
                transportation.setTransportationType(rs.getString("transportation_type"));
                transportation.setDescription(rs.getString("description"));
                transportation.setPricePerHour(rs.getDouble("price_per_hour"));

                Destinations destination = new Destinations();
                destination.setDestinationsID(rs.getInt("destination_id"));
                transportation.setDestinationID(destination);

                return transportation;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving transportation: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transportation> getAll() {
        List<Transportation> transportationList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transportation transportation = new Transportation();
                transportation.setTransportationID(rs.getInt("transportation_id"));
                transportation.setTransportationType(rs.getString("transportation_type"));
                transportation.setDescription(rs.getString("description"));
                transportation.setPricePerHour(rs.getDouble("price_per_hour"));

                Destinations destination = new Destinations();
                destination.setDestinationsID(rs.getInt("destination_id"));
                transportation.setDestinationID(destination);

                transportationList.add(transportation);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving transportation: " + e.getMessage());
            e.printStackTrace();
        }
        return transportationList;
    }

    @Override
    public Transportation update(Transportation transportation) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, transportation.getTransportationType());
            ps.setString(2, transportation.getDescription());
            ps.setDouble(3, transportation.getPricePerHour());
            ps.setInt(4, transportation.getDestinationID().getDestinationsID());
            ps.setInt(5, transportation.getTransportationID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return transportation;
            }
        } catch (SQLException e) {
            System.out.println("Error updating transportation: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Transportation delete(Transportation transportation) {
        int transportationID = transportation.getTransportationID();
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, transportationID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Transportation with ID: " + transportationID + " deleted successfully");
            } else {
                System.out.println("No Transportation with ID: " + transportationID + " found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting transportation: " + e.getMessage());
            e.printStackTrace();
        }
        return transportation;
    }
}
