package Service_Layer;

import Business_Aspects.HotelBookings;
import DAO.HotelBookingsDAO;

import java.util.List;

public class HotelBookingsService {
    private HotelBookingsDAO hotelBookingsDAO;

    public HotelBookingsService(HotelBookingsDAO hotelBookingsDAO) {
        this.hotelBookingsDAO = hotelBookingsDAO;
    }

    public HotelBookings create(HotelBookings hotelBooking) {
        return hotelBookingsDAO.create(hotelBooking);
    }

    public HotelBookings getById(int id) {
        return hotelBookingsDAO.getById(id);
    }

    public List<HotelBookings> getAll() {
        return hotelBookingsDAO.getAll();
    }

    public HotelBookings update(HotelBookings hotelBooking) {
        return hotelBookingsDAO.update(hotelBooking);
    }

    public HotelBookings delete(HotelBookings hotelBooking) {
        return hotelBookingsDAO.delete(hotelBooking);
    }
}
