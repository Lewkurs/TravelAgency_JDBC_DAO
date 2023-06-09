package DAO;

import Business_Aspects.Bookings;
import java.util.List;

public interface BookingsDAO {
    Bookings getBookingsByID(int id);
    List<Bookings> getAllBookings();
    void save(Bookings booking);
    void update(Bookings booking);
    void delete(Bookings booking);
}
