package Service_Layer;

import Business_Aspects.DestinationBookings;
import DAO.DestinationBookingsDAO;

import java.util.List;

public class DestinationBookingsService {
    private DestinationBookingsDAO destinationBookingsDAO;

    public DestinationBookingsService(DestinationBookingsDAO destinationBookingsDAO) {
        this.destinationBookingsDAO = destinationBookingsDAO;
    }

    public DestinationBookings create(DestinationBookings destinationBooking) {
        return destinationBookingsDAO.create(destinationBooking);
    }

    public DestinationBookings getById(int id) {
        return destinationBookingsDAO.getById(id);
    }

    public List<DestinationBookings> getAll() {
        return destinationBookingsDAO.getAll();
    }

    public DestinationBookings update(DestinationBookings destinationBooking) {
        return destinationBookingsDAO.update(destinationBooking);
    }

    public DestinationBookings delete(DestinationBookings destinationBooking) {
        return destinationBookingsDAO.delete(destinationBooking);
    }
}
