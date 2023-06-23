package DAO;

import Business_Aspects.Bookings;
import java.util.List;

public interface BookingsDAO extends IDAO<Bookings> {

    Bookings create(Bookings booking); // Create a new booking

    Bookings getById(int bookingID); // Get a booking by its ID

    List<Bookings> getAll(); // Get all bookings

    Bookings update(Bookings booking); // Update a booking

    Bookings delete(int bookingID); // Delete a booking
}
