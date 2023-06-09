package Service_Layer;

import DAO.AbstractDAO;
import DAO.DestinationsDAO;
import Business_Aspects.Destinations;
import java.util.List;


public class DestinationsService {
    private DestinationsDAO destinationsDAO;

    public DestinationsService(AbstractDAO<Destinations> destinationsDAO) {
        this.destinationsDAO = (DestinationsDAO) destinationsDAO;
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
