package DAO;

import Business_Aspects.Payments;

import java.util.List;

public interface PaymentsDAO extends IDAO<Payments> {

        Payments create(Payments payment); // Create a new payment

        Payments getById(int paymentID); // Get a payment by its ID

        List<Payments> getAll(); // Get all payments

        Payments update(Payments payment); // Update a payment

        Payments delete(Payments payment); // Delete a payment

}
