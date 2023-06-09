package Service_Layer;

import DAO.DestinationsDAO;
import Business_Aspects.Destinations;
import java.util.List;


public class DestinationsService {
    private DestinationsDAO destinationsDAO;

    public DestinationsService(DestinationsDAO destinationsDAO) {
        this.destinationsDAO = destinationsDAO;
    }

    public Destinations getDestinationByID(int id) {
        return destinationsDAO.getDestinationsByID(id);
    }

    public List<Destinations> getAllDestinations() {
        return destinationsDAO.getAllDestinations();
    }

    public void saveDestination(Destinations destination) {
        destinationsDAO.save(destination);
    }

    public void updateDestination(Destinations destination) {
        destinationsDAO.update(destination);
    }

    public void deleteDestination(Destinations destination) {
        destinationsDAO.delete(destination);
    }
}
