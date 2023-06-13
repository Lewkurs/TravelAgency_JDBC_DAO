package DAO;

import Business_Aspects.Customers;
import java.util.List;
public interface CustomersDAO extends IDAO<Customers> {

     Customers create(Customers customer); // Create a new customer

     Customers getById(int customerID); // Get a customer by its ID

     List<Customers> getAll(); // Get all customers

     Customers update(Customers customer); // Update a customer

     Customers delete(Customers customer); // Delete a customer
}
