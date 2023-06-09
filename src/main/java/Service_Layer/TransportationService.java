package Service_Layer;

import Business_Aspects.Transportation;
import DAO.TransportationDAO;

import java.util.List;

public class TransportationService {
    private TransportationDAO transportationDAO;

    public TransportationService(TransportationDAO transportationDAO) {
        this.transportationDAO = transportationDAO;
    }

    public Transportation getTransportationByID(int id) {
        return transportationDAO.getTransportationByID(id);
    }

    public List<Transportation> getAllTransportations() {
        return transportationDAO.getAllTransportations();
    }

    public void saveTransportation(Transportation transportation) {
        transportationDAO.save(transportation);
    }

    public void updateTransportation(Transportation transportation) {
        transportationDAO.update(transportation);
    }

    public void deleteTransportation(Transportation transportation) {
        transportationDAO.delete(transportation);
    }
}
