package Service_Layer;

import Business_Aspects.Payments;
import DAO.PaymentsDAO;
import DAOImplementations.PaymentsDAOImpl;

import java.util.List;

import java.util.List;

public class PaymentsService {
    private PaymentsDAOImpl paymentsDAO;

    public PaymentsService(PaymentsDAOImpl paymentsDAO) {
        this.paymentsDAO = paymentsDAO;
    }

    public Payments create(Payments payment) {
        return paymentsDAO.create(payment);
    }

    public Payments getById(int id) {
        return paymentsDAO.getById(id);
    }

    public List<Payments> getAll() {
        return paymentsDAO.getAll();
    }

    public Payments update(Payments payment) {
        return paymentsDAO.update(payment);
    }

    public Payments delete(Payments payment) {
        return paymentsDAO.delete(payment);
    }
}

