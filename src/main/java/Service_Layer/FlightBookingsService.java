package Service_Layer;

import Business_Aspects.FlightBookings;
import DAO.FlightBookingsDAO;

import java.util.List;

public class FlightBookingsService {
    private FlightBookingsDAO flightBookingsDAO;

    public FlightBookingsService(FlightBookingsDAO flightBookingsDAO) {
        this.flightBookingsDAO = flightBookingsDAO;
    }

    public List<FlightBookings> getAllFlightBookings() {
        return flightBookingsDAO.getAllFlightBookings();
    }

    public void saveFlightBooking(FlightBookings flightBooking) {
        flightBookingsDAO.save(flightBooking);
    }

    public void updateFlightBooking(FlightBookings flightBooking) {
        flightBookingsDAO.update(flightBooking);
    }

    public void deleteFlightBooking(FlightBookings flightBooking) {
        flightBookingsDAO.delete(flightBooking);
    }
}

