package DAO;

import Business_Aspects.DestinationBookings;
import java.util.List;
public interface DestinationBookingsDAO extends IDAO<DestinationBookings> {

     DestinationBookings create(DestinationBookings destinationBooking); // Create a new destinationBooking

     DestinationBookings getById(int destinationBookingID); // Get a destinationBooking by its ID

     List<DestinationBookings> getAll(); // Get all destinationBookings

     DestinationBookings update(DestinationBookings destinationBooking); // Update a destinationBooking

     DestinationBookings delete(DestinationBookings destinationBooking); // Delete a destinationBooking
}
