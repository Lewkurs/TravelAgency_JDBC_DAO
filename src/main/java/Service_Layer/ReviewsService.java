package Service_Layer;

import Business_Aspects.Reviews;
import DAO.ReviewsDAO;

import java.util.List;

public class ReviewsService {
    private ReviewsDAO reviewsDAO;

    public ReviewsService(ReviewsDAO reviewsDAO) {
        this.reviewsDAO = reviewsDAO;
    }

    public Reviews create(Reviews review) {
        return reviewsDAO.create(review);
    }

    public Reviews getById(int id) {
        return reviewsDAO.getById(id);
    }

    public List<Reviews> getAll() {
        return reviewsDAO.getAll();
    }

    public Reviews update(Reviews review) {
        return reviewsDAO.update(review);
    }

    public Reviews delete(Reviews review) {
        return reviewsDAO.delete(review);
    }
}
