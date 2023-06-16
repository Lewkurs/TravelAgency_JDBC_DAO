package DAOImplementations;

import Business_Aspects.Activities;
import Business_Aspects.Destinations;
import DAO.ActivitiesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnectionPool;

public class ActivitiesDAOImpl implements ActivitiesDAO {

    private ResultSet rs = null;

    public Activities create(Activities activity) {
        String query = "INSERT INTO activities(activity_name, activity_description, activity_price, destination_id) VALUES (?, ?, ?, ?)";

        // Establish a connection
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, activity.getActivityName());
            ps.setString(2, activity.getActivityDescription());
            ps.setString(3, activity.getActivityPrice());
            ps.setInt(4, activity.getDestination().getDestinationsID());

            // Execute the query
            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            System.out.println("Error creating activity: " + e.getMessage());
            e.printStackTrace();
        }
        return activity;
    }
    // Get an activity object from the result set
    public Activities getById(int activityID) {
        String query = "SELECT * FROM activities WHERE activity_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, activityID);
            // Execute the query
            rs = ps.executeQuery();

            if (rs.next()) {
                // Create and return the activity object
                return getActivityFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving activity: " + e.getMessage());
            e.printStackTrace();
            // Return null in case of an error
        }
        return null;
    }
    // Select an activity from the result set
    public List<Activities> getAll() {
        List<Activities> activityList = new ArrayList<>();
        String query = "SELECT * FROM activities";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {

            // Execute the query
            rs = st.executeQuery();

            while (rs.next()) {
                // Create an activity object for each row and add it to the list
                Activities activity = getActivityFromResultSet(rs);
                activityList.add(activity);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving activities: " + e.getMessage());
            e.printStackTrace();
        }
        return activityList;
    }

    public Activities update(Activities activity) {
        String query = "UPDATE activities SET activity_name = ?, activity_description = ?, activity_price = ?, destination_id = ? WHERE activity_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, activity.getActivityName());
            ps.setString(2, activity.getActivityDescription());
            ps.setString(3, activity.getActivityPrice());
            ps.setInt(4, activity.getDestination().getDestinationsID());
            ps.setInt(5, activity.getActivityID());

            // Execute the query
            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            System.out.println("Error updating activity: " + e.getMessage());
            e.printStackTrace();
        }
        return activity;
    }

    @Override
    public Activities delete(Activities activity) {
        return null;
    }


    public Activities delete(int activityID) {
        String query = "DELETE FROM activities WHERE activity_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, activityID);

            // Execute the query
            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row(s) deleted.");

            if (rowsAffected > 0) {
                System.out.println("Activity with ID: " + activityID + " deleted successfully");
            } else {
                System.out.println("No activity with ID: " + activityID + " found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting activity: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private Activities getActivityFromResultSet(ResultSet rs) throws SQLException {
        int activityID = rs.getInt("activity_id");
        String activityName = rs.getString("activity_name");
        String activityDescription = rs.getString("activity_description");
        String activityPrice = rs.getString("activity_price");

        Destinations destination = new Destinations();
        destination.setDestinationsID(rs.getInt("destination_id"));

        return new Activities(activityID, activityName, activityDescription, activityPrice, destination);
    }

}

