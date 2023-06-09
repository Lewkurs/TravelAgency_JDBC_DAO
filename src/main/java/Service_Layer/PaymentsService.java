package Service_Layer;

import Business_Aspects.Payments;
import DAO.PaymentsDAO;

import java.util.List;

public class PaymentsService {
    private PaymentsDAO paymentsDAO;

    public PaymentsService(PaymentsDAO paymentsDAO) {
        this.paymentsDAO = paymentsDAO;
    }

    public Payments getPaymentByID(int id) {
        return paymentsDAO.getPaymentsByID(id);
    }

    public List<Payments> getAllPayments() {
        return paymentsDAO.getAllPayments();
    }

    public void savePayment(Payments payment) {
        paymentsDAO.save(payment);
    }

    public void updatePayment(Payments payment) {
        paymentsDAO.update(payment);
    }

    public void deletePayment(Payments payment) {
        paymentsDAO.delete(payment);
    }
}
