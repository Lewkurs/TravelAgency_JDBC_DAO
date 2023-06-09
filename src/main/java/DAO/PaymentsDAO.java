package DAO;

import Business_Aspects.Payments;

import java.util.List;

public interface PaymentsDAO {
    Payments getPaymentsByID(int id);
    List<Payments> getAllPayments();
    void save(Payments payments);
    void update(Payments payments);
    void delete(Payments payments);
}
