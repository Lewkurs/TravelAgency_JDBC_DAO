package Service_Layer;

import Business_Aspects.Reviews;
import DAO.ReviewsDAO;

import java.util.List;

public class ReviewsService {
    private ReviewsDAO reviewsDAO;

    public ReviewsService(ReviewsDAO reviewsDAO) {
        this.reviewsDAO = reviewsDAO;
    }

    public Reviews getReviewByID(int id) {
        return reviewsDAO.getReviewsByID(id);
    }

    public List<Reviews> getAllReviews() {
        return reviewsDAO.getAllReviews();
    }

    public void saveReview(Reviews review) {
        reviewsDAO.save(review);
    }

    public void updateReview(Reviews review) {
        reviewsDAO.update(review);
    }

    public void deleteReview(Reviews review) {
        reviewsDAO.delete(review);
    }
}
