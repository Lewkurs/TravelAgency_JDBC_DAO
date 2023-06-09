package Service_Layer;

import DAO.DestinationBookingsDAO;
import Business_Aspects.DestinationBookings;

import java.util.List;

public class DestinationBookingsService {
    private DestinationBookingsDAO destinationBookingsDAO;

    public DestinationBookingsService(DestinationBookingsDAO destinationBookingsDAO) {
        this.destinationBookingsDAO = destinationBookingsDAO;
    }


    public List<DestinationBookings> getAllDestinationBookings() {
        return destinationBookingsDAO.getAllDestinationBookings();
    }

    public void saveDestinationBooking(DestinationBookings destinationBooking) {
        destinationBookingsDAO.save(destinationBooking);
    }

    public void updateDestinationBooking(DestinationBookings destinationBooking) {
        destinationBookingsDAO.update(destinationBooking);
    }

    public void deleteDestinationBooking(DestinationBookings destinationBooking) {
        destinationBookingsDAO.delete(destinationBooking);
    }
}

