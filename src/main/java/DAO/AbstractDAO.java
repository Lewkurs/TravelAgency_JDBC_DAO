package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public T findById(int id) {
        T entity = null;
        // Implementation specific to the project
        String query = "SELECT * FROM destinations WHERE id = 2";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        // Implementation specific to the project
        String query = "SELECT * FROM destinations";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T entity = mapResultSetToEntity(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void save(T entity) {
        // Implementation specific to the project
        String query = "INSERT INTO hotels (Hotel_Name, Address, Destinations_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the parameters for the insert query

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        // Implementation specific to the project
        String query = "UPDATE destinations SET Description = ?, Price = ? WHERE Name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the parameters for the update query

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        // Implementation specific to the project
        String query = "DELETE FROM hotels WHERE Hotel_Name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the parameters for the delete query

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
