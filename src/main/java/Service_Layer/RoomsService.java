package Service_Layer;

import Business_Aspects.Rooms;
import DAO.RoomsDAO;

import java.util.List;

public class RoomsService {
    private RoomsDAO roomsDAO;

    public RoomsService(RoomsDAO roomsDAO) {
        this.roomsDAO = roomsDAO;
    }

    public Rooms getRoomByID(int id) {
        return roomsDAO.getRoomByID(id);
    }

    public List<Rooms> getAllRooms() {
        return roomsDAO.getAllRooms();
    }

    public void saveRoom(Rooms room) {
        roomsDAO.save(room);
    }

    public void updateRoom(Rooms room) {
        roomsDAO.update(room);
    }

    public void deleteRoom(Rooms room) {
        roomsDAO.delete(room);
    }
}
