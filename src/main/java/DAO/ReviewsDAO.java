package DAO;

import Business_Aspects.Reviews;

import java.util.List;

public interface ReviewsDAO {
    Reviews getReviewsByID(int id);
    List<Reviews> getAllReviews();
    void save(Reviews reviews);
    void update(Reviews reviews);
    void delete(Reviews reviews);
}
