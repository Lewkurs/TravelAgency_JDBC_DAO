package Service_Layer;

import Business_Aspects.Flights;
import DAO.FlightsDAO;

import java.util.List;

public class FlightsService {
    private FlightsDAO flightsDAO;

    public FlightsService(FlightsDAO flightsDAO) {
        this.flightsDAO = flightsDAO;
    }

    public Flights getFlightByID(int id) {
        return flightsDAO.getFlightsByID(id);
    }

    public List<Flights> getAllFlights() {
        return flightsDAO.getAllFlights();
    }

    public void saveFlight(Flights flight) {
        flightsDAO.save(flight);
    }

    public void updateFlight(Flights flight) {
        flightsDAO.update(flight);
    }

    public void deleteFlight(Flights flight) {
        flightsDAO.delete(flight);
    }
}
