package DAOImplementations;

import Business_Aspects.Activities;
import Business_Aspects.Destinations;
import DAO.ActivitiesDAO;
import DAO.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivitiesDAOImpl implements ActivitiesDAO {

    private static final Logger logger = Logger.getLogger(ActivitiesDAOImpl.class.getName());
    private ResultSet rs = null;

    public Activities create(Activities activity) {
        String query = "INSERT INTO activities(activity_name, activity_description, activity_price, destination_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, activity.getActivityName());
            ps.setString(2, activity.getActivityDescription());
            ps.setString(3, activity.getActivityPrice());
            ps.setInt(4, activity.getDestinationID().getDestinationsID()); // Corrected this line

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating activity: " + e.getMessage(), e);
        }
        return activity;
    }


    public Activities getById(int activityID) {
        String query = "SELECT * FROM activities WHERE activity_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, activityID);
            rs = ps.executeQuery();

            if (rs.next()) {
                return getActivityFromResultSet(rs);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving activity: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Activities> getAll() {
        List<Activities> activityList = new ArrayList<>();
        String query = "SELECT * FROM activities";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {

            rs = st.executeQuery();

            while (rs.next()) {
                Activities activity = getActivityFromResultSet(rs);
                activityList.add(activity);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving activities: " + e.getMessage(), e);
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
            ps.setInt(4, activity.getDestinationID().getDestinationsID());
            ps.setInt(5, activity.getActivityID());

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating activity: " + e.getMessage(), e);
        }
        return activity;
    }

    @Override
    public Activities delete(Activities activity) {
        int activityID = activity.getActivityID();
        String query = "DELETE FROM activities WHERE activity_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, activityID);

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, rowsAffected + " row(s) deleted.");

            if (rowsAffected > 0) {
                logger.log(Level.INFO, "Activity with ID: " + activityID + " deleted successfully");
            } else {
                logger.log(Level.INFO, "No activity with ID: " + activityID + " found");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting activity: " + e.getMessage(), e);
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
