package DAO;

import Business_Aspects.Hotels;

import java.util.List;

public interface HotelsDAO extends IDAO<Hotels> {

    Hotels create(Hotels hotel); // Create a new hotel

    Hotels getById(int hotelID); // Get a hotel by its ID

    List<Hotels> getAll(); // Get all hotels

    Hotels update(Hotels hotel); // Update a hotel

    Hotels delete(Hotels hotel); // Delete a hotel
}
