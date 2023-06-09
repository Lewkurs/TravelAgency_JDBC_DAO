package DAO;
import Business_Aspects.Flights;
import java.util.List;
public interface FlightsDAO {
    Flights getFlightsByID(int id);
    List<Flights> getAllFlights();
    void save(Flights flight);
    void update(Flights flight);
    void delete(Flights flight);
}
