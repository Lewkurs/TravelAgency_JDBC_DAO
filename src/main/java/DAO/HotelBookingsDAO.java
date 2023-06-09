package DAO;

import Business_Aspects.HotelBookings;

import java.util.List;

public interface HotelBookingsDAO {
    List<HotelBookings> getAllHotelBookings();
    void save(HotelBookings hotelBookings);
    void update(HotelBookings hotelBookings);
    void delete(HotelBookings hotelBookings);
}
