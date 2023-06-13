package DAO;

import Business_Aspects.Rooms;
import java.util.List;
public interface RoomsDAO extends IDAO<Rooms> {

            Rooms create(Rooms room); // Create a new room

            Rooms getById(int roomID); // Get a room by its ID

            List<Rooms> getAll(); // Get all rooms

            Rooms update(Rooms room); // Update a room

            Rooms delete(Rooms room); // Delete a room
}
