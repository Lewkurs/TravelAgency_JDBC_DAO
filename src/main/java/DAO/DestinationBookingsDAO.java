package DAO;

import Business_Aspects.DestinationBookings;
import java.util.List;
public interface DestinationBookingsDAO {
    List<DestinationBookings> getAllDestinationBookings();
    void save(DestinationBookings destinationBookings);
    void update(DestinationBookings destinationBookings);
    void delete(DestinationBookings destinationBookings);
}
