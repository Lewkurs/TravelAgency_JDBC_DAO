package DAO;

import Business_Aspects.Reviews;

import java.util.List;

public interface ReviewsDAO extends IDAO<Reviews> {

        Reviews create(Reviews review); // Create a new review

        Reviews getById(int reviewID); // Get a review by its ID

        List<Reviews> getAll(); // Get all reviews

        Reviews update(Reviews review); // Update a review

        Reviews delete(Reviews review); // Delete a review
}
