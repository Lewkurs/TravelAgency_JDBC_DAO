package DAO;

import Business_Aspects.Transportation;

import java.util.List;

public interface TransportationDAO {
    Transportation getTransportationByID(int id);
    List<Transportation> getAllTransportations();
    void save(Transportation transportation);
    void update(Transportation transportation);
    void delete(Transportation transportation);
}
