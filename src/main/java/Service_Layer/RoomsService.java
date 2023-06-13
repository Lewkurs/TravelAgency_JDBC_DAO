package Service_Layer;

import Business_Aspects.Rooms;
import DAO.RoomsDAO;
import DAOImplementations.RoomsDAOImpl;

import java.util.List;

import java.util.List;

public class RoomsService {
    private RoomsDAOImpl roomsDAO;

    public RoomsService(RoomsDAOImpl roomsDAO) {
        this.roomsDAO = roomsDAO;
    }

    public Rooms create(Rooms room) {
        return roomsDAO.create(room);
    }

    public Rooms getById(int id) {
        return roomsDAO.getById(id);
    }

    public List<Rooms> getAll() {
        return roomsDAO.getAll();
    }

    public Rooms update(Rooms room) {
        return roomsDAO.update(room);
    }

    public Rooms delete(Rooms room) {
        return roomsDAO.delete(room);
    }
}

