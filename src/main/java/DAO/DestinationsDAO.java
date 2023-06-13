package DAO;

import Business_Aspects.Destinations;
import java.util.List;
public interface DestinationsDAO extends IDAO<Destinations> {

     Destinations create(Destinations destination); // Create a new destination

     Destinations getById(int destinationID); // Get a destination by its ID

     List<Destinations> getAll(); // Get all destinations

     Destinations update(Destinations destination); // Update a destination

     Destinations delete(Destinations destination); // Delete a destination
}
