package Service_Layer;

import Business_Aspects.FlightBookings;
import DAO.FlightBookingsDAO;
import DAOImplementations.FlightBookingsDAOImpl;

import java.util.List;

import java.util.List;

public class FlightBookingsService {
    private FlightBookingsDAOImpl flightBookingsDAO;

    public FlightBookingsService(FlightBookingsDAOImpl flightBookingsDAO) {
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


