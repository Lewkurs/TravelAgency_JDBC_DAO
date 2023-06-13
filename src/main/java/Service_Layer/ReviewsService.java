package Service_Layer;

import Business_Aspects.Reviews;
import DAO.ReviewsDAO;
import DAOImplementations.ReviewsDAOImpl;

import java.util.List;

import java.util.List;

public class ReviewsService {
    private ReviewsDAOImpl reviewsDAO;

    public ReviewsService(ReviewsDAOImpl reviewsDAO) {
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

