package DAO;
import Business_Aspects.Flights;
import java.util.List;
public interface FlightsDAO extends IDAO<Flights> {

        Flights create(Flights flight); // Create a new flight

        Flights getById(int flightID); // Get a flight by its ID

        List<Flights> getAll(); // Get all flights

        Flights update(Flights flight); // Update a flight

        Flights delete(Flights flight); // Delete a flight
}
