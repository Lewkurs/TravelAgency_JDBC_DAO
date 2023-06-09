package DAO;

import Business_Aspects.Rooms;
import java.util.List;
public interface RoomsDAO {
    Rooms getRoomByID(int id);
    List<Rooms> getAllRooms();
    void save(Rooms rooms);
    void update(Rooms rooms);
    void delete(Rooms rooms);
}
