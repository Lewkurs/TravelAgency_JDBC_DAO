package DAO;

import Business_Aspects.HotelBookings;

import java.util.List;

public interface HotelBookingsDAO extends IDAO<HotelBookings> {

        HotelBookings create(HotelBookings hotelBooking); // Create a new hotel booking

        HotelBookings getById(int hotelBookingID); // Get a hotel booking by its ID

        List<HotelBookings> getAll(); // Get all hotel bookings

        HotelBookings update(HotelBookings hotelBooking); // Update a hotel booking

        HotelBookings delete(HotelBookings hotelBooking); // Delete a hotel booking
}
