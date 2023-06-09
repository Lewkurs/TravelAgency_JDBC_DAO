package DAO;

import Business_Aspects.Hotels;

import java.util.List;

public interface HotelsDAO {
    Hotels getHotelsByID(int id);
    List<Hotels> getAllHotels();
    void save(Hotels hotels);
    void update(Hotels hotels);
    void delete(Hotels hotels);
}
