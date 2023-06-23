package Service_Layer;

import Business_Aspects.FlightBookings;
import DAO.FlightBookingsDAO;

import java.util.List;

public class FlightBookingsService {
    private FlightBookingsDAO flightBookingsDAO;

    public FlightBookingsService(FlightBookingsDAO flightBookingsDAO) {
        this.flightBookingsDAO = flightBookingsDAO;
    }

    public FlightBookings create(FlightBookings flightBooking) {
        return flightBookingsDAO.create(flightBooking);
    }

    public FlightBookings getById(int id) {
        return flightBookingsDAO.getById(id);
    }

    public List<FlightBookings> getAll() {
        return flightBookingsDAO.getAll();
    }

    public FlightBookings update(FlightBookings flightBooking) {
        return flightBookingsDAO.update(flightBooking);
    }

    public FlightBookings delete(FlightBookings flightBooking) {
        return flightBookingsDAO.delete(flightBooking);
    }
}
