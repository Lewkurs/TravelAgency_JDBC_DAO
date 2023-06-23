package Service_Layer;

import Business_Aspects.Hotels;
import DAO.HotelsDAO;

import java.util.List;

public class HotelsService {
    private HotelsDAO hotelsDAO;

    public HotelsService(HotelsDAO hotelsDAO) {
        this.hotelsDAO = hotelsDAO;
    }

    public Hotels create(Hotels hotel) {
        return hotelsDAO.create(hotel);
    }

    public Hotels getById(int id) {
        return hotelsDAO.getById(id);
    }

    public List<Hotels> getAll() {
        return hotelsDAO.getAll();
    }

    public Hotels update(Hotels hotel) {
        return hotelsDAO.update(hotel);
    }

    public Hotels delete(Hotels hotel) {
        return hotelsDAO.delete(hotel);
    }
}
