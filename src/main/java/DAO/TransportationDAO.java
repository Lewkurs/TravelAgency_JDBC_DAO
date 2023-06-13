package DAO;

import Business_Aspects.Transportation;

import java.util.List;

public interface TransportationDAO extends IDAO<Transportation> {

        Transportation create(Transportation transportation); // Create a new transportation

        Transportation getById(int transportationID); // Get a transportation by its ID

        List<Transportation> getAll(); // Get all transportations

        Transportation update(Transportation transportation); // Update a transportation

        Transportation delete(Transportation transportation); // Delete a transportation
}
