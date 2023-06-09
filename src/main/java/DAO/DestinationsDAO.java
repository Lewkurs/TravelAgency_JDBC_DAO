package DAO;

import Business_Aspects.Destinations;
import java.util.List;
public interface DestinationsDAO {
    Destinations getDestinationsByID(int id);
    List<Destinations> getAllDestinations();
    void save(Destinations destinations);
    void update(Destinations destinations);
    void delete(Destinations destinations);
}
