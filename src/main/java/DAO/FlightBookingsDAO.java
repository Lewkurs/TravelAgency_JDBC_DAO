package DAO;

import Business_Aspects.FlightBookings;
import java.util.List;
public interface FlightBookingsDAO extends IDAO<FlightBookings> {

      FlightBookings create(FlightBookings flightBooking); // Create a new flight booking

      FlightBookings getById(int flightBookingID); // Get a flight booking by its ID

      List<FlightBookings> getAll(); // Get all flight bookings

      FlightBookings update(FlightBookings flightBooking); // Update a flight booking

      FlightBookings delete(FlightBookings flightBooking); // Delete a flight booking
}
