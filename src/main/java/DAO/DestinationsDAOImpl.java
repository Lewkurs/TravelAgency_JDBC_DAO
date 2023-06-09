package DAO;

import Business_Aspects.Destinations;
import DAO.AbstractDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinationsDAOImpl extends AbstractDAO<Destinations> {

    public DestinationsDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Destinations> findAll() {
        List<Destinations> destinations = new ArrayList<>();

        String query = "SELECT * FROM destinations";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Destinations destination = new Destinations();
                destination.setDestinationsID(resultSet.getInt("destination_id"));
                destination.setName(resultSet.getString("name"));
                destination.setDescription(resultSet.getString("description"));
                destination.setPrice(resultSet.getDouble("price"));
                destinations.add(destination);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinations;
    }

    @Override
    public Destinations findById(int id) {
        String query = "SELECT * FROM destinations WHERE destination_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Destinations destination = new Destinations();
                    destination.setDestinationsID(resultSet.getInt("destination_id"));
                    destination.setName(resultSet.getString("name"));
                    destination.setDescription(resultSet.getString("description"));
                    destination.setPrice(resultSet.getDouble("price"));
                    return destination;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Destinations destination) {
        String query = "INSERT INTO destinations (destination_id, name, description, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, destination.getDestinationsID());
            statement.setString(2, destination.getName());
            statement.setString(3, destination.getDescription());
            statement.setDouble(4, destination.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Destinations destination) {
        String query = "UPDATE destinations SET name = ?, description = ?, price = ? WHERE destination_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, destination.getName());
            statement.setString(2, destination.getDescription());
            statement.setDouble(3, destination.getPrice());
            statement.setInt(4, destination.getDestinationsID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Destinations destination) {
        String query = "DELETE FROM destinations WHERE destination_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, destination.getDestinationsID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
