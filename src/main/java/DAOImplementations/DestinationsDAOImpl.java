package DAOImplementations;

import DAO.DestinationsDAO;
import Business_Aspects.Destinations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DestinationsDAOImpl implements DestinationsDAO {

    private static final String INSERT_QUERY = "INSERT INTO destinations(name, description, price) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM destinations WHERE destination_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM destinations";
    private static final String UPDATE_QUERY = "UPDATE destinations SET name = ?, description = ?, price = ? WHERE destination_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM destinations WHERE destination_id = ?";

    private Connection connection;

    public DestinationsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Destinations create(Destinations destination) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, destination.getName());
            ps.setString(2, destination.getDescription());
            ps.setDouble(3, destination.getPrice());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    destination.setDestinationsID(generatedId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating destination: " + e.getMessage());
            e.printStackTrace();
        }
        return destination;
    }

    @Override
    public Destinations getById(int destinationID) {
        Destinations destination = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, destinationID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                destination = new Destinations();
                destination.setDestinationsID(rs.getInt("destination_id"));
                destination.setName(rs.getString("name"));
                destination.setDescription(rs.getString("description"));
                destination.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving destination: " + e.getMessage());
            e.printStackTrace();
        }
        return destination;
    }

    @Override
    public List<Destinations> getAll() {
        List<Destinations> destinationList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Destinations destination = new Destinations();
                destination.setDestinationsID(rs.getInt("destination_id"));
                destination.setName(rs.getString("name"));
                destination.setDescription(rs.getString("description"));
                destination.setPrice(rs.getDouble("price"));
                destinationList.add(destination);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving destinations: " + e.getMessage());
            e.printStackTrace();
        }
        return destinationList;
    }

    @Override
    public Destinations update(Destinations destination) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, destination.getName());
            ps.setString(2, destination.getDescription());
            ps.setDouble(3, destination.getPrice());
            ps.setInt(4, destination.getDestinationsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return destination;
            }
        } catch (SQLException e) {
            System.out.println("Error updating destination: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Destinations delete(Destinations destination) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, destination.getDestinationsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return destination;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting destination: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
