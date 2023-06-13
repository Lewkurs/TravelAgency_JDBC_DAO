package Service_Layer;

import java.util.List;
import Business_Aspects.Bookings;
import DAO.BookingsDAO;
import DAOImplementations.BookingsDAOImpl;

import java.util.List;

public class BookingsService {
    private BookingsDAOImpl bookingsDAO;

    public BookingsService(BookingsDAOImpl bookingsDAO) {
        this.bookingsDAO = bookingsDAO;
    }

    public Bookings create(Bookings booking) {
        return bookingsDAO.create(booking);
    }

    public Bookings getById(int id) {
        return bookingsDAO.getById(id);
    }

    public List<Bookings> getAll() {
        return bookingsDAO.getAll();
    }

    public Bookings update(Bookings booking) {
        return bookingsDAO.update(booking);
    }

    public Bookings delete(Bookings booking) {
        return bookingsDAO.delete(booking);
    }
}


