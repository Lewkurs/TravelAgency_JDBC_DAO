package Service_Layer;

import Business_Aspects.Destinations;
import DAO.DestinationsDAO;

import java.util.List;

public class DestinationsService {
    private DestinationsDAO destinationsDAO;

    public DestinationsService(DestinationsDAO destinationsDAO) {
        this.destinationsDAO = destinationsDAO;
    }

    public Destinations create(Destinations destination) {
        return destinationsDAO.create(destination);
    }

    public Destinations getById(int id) {
        return destinationsDAO.getById(id);
    }

    public List<Destinations> getAll() {
        return destinationsDAO.getAll();
    }

    public Destinations update(Destinations destination) {
        return destinationsDAO.update(destination);
    }

    public Destinations delete(Destinations destination) {
        return destinationsDAO.delete(destination);
    }
}
