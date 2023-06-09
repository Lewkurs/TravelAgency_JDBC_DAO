package Service_Layer;

import java.util.List;
import Business_Aspects.Bookings;
import DAO.BookingsDAO;

public class BookingsService {
    private BookingsDAO bookingsDAO;

    public BookingsService(BookingsDAO bookingsDAO) {
        this.bookingsDAO = bookingsDAO;
    }

    public Bookings getBookingByID(int id) {
        return bookingsDAO.getBookingsByID(id);
    }

    public List<Bookings> getAllBookings() {
        return bookingsDAO.getAllBookings();
    }

    public void saveBooking(Bookings booking) {
        bookingsDAO.save(booking);
    }

    public void updateBooking(Bookings booking) {
        bookingsDAO.update(booking);
    }

    public void deleteBooking(Bookings booking) {
        bookingsDAO.delete(booking);
    }
}

