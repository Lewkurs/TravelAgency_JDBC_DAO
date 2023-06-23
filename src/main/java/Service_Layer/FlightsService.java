package Service_Layer;

import Business_Aspects.Flights;
import DAO.FlightsDAO;

import java.util.List;

public class FlightsService {
    private FlightsDAO flightsDAO;

    public FlightsService(FlightsDAO flightsDAO) {
        this.flightsDAO = flightsDAO;
    }

    public Flights create(Flights flight) {
        return flightsDAO.create(flight);
    }

    public Flights getById(int id) {
        return flightsDAO.getById(id);
    }

    public List<Flights> getAll() {
        return flightsDAO.getAll();
    }

    public Flights update(Flights flight) {
        return flightsDAO.update(flight);
    }

    public Flights delete(Flights flight) {
        return flightsDAO.delete(flight);
    }
}
