package DAO;

import Business_Aspects.Activities;
import Business_Aspects.Destinations;
import DAO.ConnectionPool;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public interface ActivitiesDAO {

    Activities getActivitiesByID(int id);
    List<Activities> getAllActivities();
    void save(Activities activities);
    void update(Activities activities);
    void delete(Activities activities);
}



   /* private Connection connection;

    public ActivitiesDAO() {
        this.connection = connection;
    }

    public void createActivity(Activities activity) {
        String insertQuery = "INSERT INTO activities (activity_id, activity_name, activity_description, activity_price, destination_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, activity.getActivityID());
            statement.setString(2, activity.getActivityName());
            statement.setString(3, activity.getActivityDescription());
            statement.setString(4, activity.getActivityPrice());
            statement.setInt(5, Destinations.getDestinationsID());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Activity created successfully.");
            } else {
                System.out.println("Failed to create activity.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/
