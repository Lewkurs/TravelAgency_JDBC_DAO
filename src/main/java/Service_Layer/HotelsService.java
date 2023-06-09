package Service_Layer;

import Business_Aspects.Hotels;
import DAO.HotelsDAO;

import java.util.List;

public class HotelsService {
    private HotelsDAO hotelsDAO;

    public HotelsService(HotelsDAO hotelsDAO) {
        this.hotelsDAO = hotelsDAO;
    }

    public Hotels getHotelByID(int id) {
        return hotelsDAO.getHotelsByID(id);
    }

    public List<Hotels> getAllHotels() {
        return hotelsDAO.getAllHotels();
    }

    public void saveHotel(Hotels hotel) {
        hotelsDAO.save(hotel);
    }

    public void updateHotel(Hotels hotel) {
        hotelsDAO.update(hotel);
    }

    public void deleteHotel(Hotels hotel) {
        hotelsDAO.delete(hotel);
    }
}
