package Service_Layer;

import Business_Aspects.HotelBookings;
import DAO.HotelBookingsDAO;

import java.util.List;

public class HotelBookingsService {
    private HotelBookingsDAO hotelBookingsDAO;

    public HotelBookingsService(HotelBookingsDAO hotelBookingsDAO) {
        this.hotelBookingsDAO = hotelBookingsDAO;
    }
    public List<HotelBookings> getAllHotelBookings() {
        return hotelBookingsDAO.getAllHotelBookings();
    }

    public void saveHotelBooking(HotelBookings hotelBooking) {
        hotelBookingsDAO.save(hotelBooking);
    }

    public void updateHotelBooking(HotelBookings hotelBooking) {
        hotelBookingsDAO.update(hotelBooking);
    }

    public void deleteHotelBooking(HotelBookings hotelBooking) {
        hotelBookingsDAO.delete(hotelBooking);
    }
}

