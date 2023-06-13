package Service_Layer;

import Business_Aspects.Transportation;
import DAO.TransportationDAO;
import DAOImplementations.TransportationDAOImpl;

import java.util.List;

import java.util.List;

public class TransportationService {
    private TransportationDAOImpl transportationDAO;

    public TransportationService(TransportationDAOImpl transportationDAO) {
        this.transportationDAO = transportationDAO;
    }

    public Transportation create(Transportation transportation) {
        return transportationDAO.create(transportation);
    }

    public Transportation getById(int id) {
        return transportationDAO.getById(id);
    }

    public List<Transportation> getAll() {
        return transportationDAO.getAll();
    }

    public Transportation update(Transportation transportation) {
        return transportationDAO.update(transportation);
    }

    public Transportation delete(Transportation transportation) {
        return transportationDAO.delete(transportation);
    }
}

