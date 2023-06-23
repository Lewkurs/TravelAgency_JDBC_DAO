package DAOImplementations;

import Business_Aspects.*;
import DAO.ReviewsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewsDAOImpl implements ReviewsDAO {

    private static final String INSERT_QUERY = "INSERT INTO reviews(rating, review_description, customer_id, hotel_id, destination_id, activity_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM reviews WHERE review_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM reviews";
    private static final String UPDATE_QUERY = "UPDATE reviews SET rating=?, review_description=?, customer_id=?, hotel_id=?, destination_id=?, activity_id=? WHERE review_id=?";
    private static final String DELETE_QUERY = "DELETE FROM reviews WHERE review_id = ?";

    private Connection connection;
    private Logger logger = Logger.getLogger(ReviewsDAOImpl.class.getName());

    public ReviewsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Reviews create(Reviews review) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, review.getRating());
            ps.setString(2, review.getReviewDescription());
            ps.setInt(3, review.getCustomerID().getCustomerID());
            ps.setInt(4, review.getHotelID().getHotelsID());
            ps.setInt(5, review.getDestinationID().getDestinationsID());
            ps.setInt(6, review.getActivityID().getActivityID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    review.setReviewsID(generatedId);
                    return review;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Error creating review: ", e);
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Reviews getById(int reviewID) {
        Reviews review = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, reviewID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                review = new Reviews();
                review.setReviewsID(rs.getInt("review_id"));
                review.setRating(rs.getInt("rating"));
                review.setReviewDescription(rs.getString("review_description"));
                // Set related entities
                Customers customer = new Customers();
                customer.setCustomerID(rs.getInt("customer_id"));
                review.setCustomerID(customer);
                Hotels hotel = new Hotels();
                hotel.setHotelsID(rs.getInt("hotel_id"));
                review.setHotelID(hotel);
                Destinations destination = new Destinations();
                destination.setDestinationsID(rs.getInt("destination_id"));
                review.setDestinationID(destination);
                Activities activity = new Activities(
                        rs.getInt("activity_id"),
                        rs.getString("activity_name"),
                        rs.getString("activity_description"),
                        rs.getString("activity_price"),
                        destination
                );
                activity.setActivityID(rs.getInt("activity_id"));
                review.setActivityID(activity);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Error retrieving review: ", e);
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public List<Reviews> getAll() {
        List<Reviews> reviewList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reviews review = new Reviews();
                review.setReviewsID(rs.getInt("review_id"));
                review.setRating(rs.getInt("rating"));
                review.setReviewDescription(rs.getString("review_description"));
                // Set related entities
                Customers customer = new Customers();
                customer.setCustomerID(rs.getInt("customer_id"));
                review.setCustomerID(customer);
                Hotels hotel = new Hotels();
                hotel.setHotelsID(rs.getInt("hotel_id"));
                review.setHotelID(hotel);
                Destinations destination = new Destinations();
                destination.setDestinationsID(rs.getInt("destination_id"));
                review.setDestinationID(destination);
                Activities activity = new Activities(
                        rs.getInt("activity_id"),
                        rs.getString("activity_name"),
                        rs.getString("activity_description"),
                        rs.getString("activity_price"),
                        destination
                );
                activity.setActivityID(rs.getInt("activity_id"));
                review.setActivityID(activity);

                reviewList.add(review);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving reviews: ", e);
            e.printStackTrace();
        }
        return reviewList;
    }

    @Override
    public Reviews update(Reviews review) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setInt(1, review.getRating());
            ps.setString(2, review.getReviewDescription());
            ps.setInt(3, review.getCustomerID().getCustomerID());
            ps.setInt(4, review.getHotelID().getHotelsID());
            ps.setInt(5, review.getDestinationID().getDestinationsID());
            ps.setInt(6, review.getActivityID().getActivityID());
            ps.setInt(7, review.getReviewsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return review;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating reviews: ", e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reviews delete(Reviews review) {
        int reviewID = review.getReviewsID();
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, reviewID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Review with ID: " + reviewID + " deleted successfully");
            } else {
                logger.info("No review with ID: " + reviewID + " found");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting review: ", e);
            e.printStackTrace();
        }
        return review;
    }
}
