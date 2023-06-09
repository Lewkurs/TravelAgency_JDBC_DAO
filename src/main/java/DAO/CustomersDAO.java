package DAO;

import Business_Aspects.Customers;
import java.util.List;
public interface CustomersDAO {
    Customers getCustomerByID(int id);
    List<Customers> getAllCustomers();
    void save(Customers customers);
    void update(Customers customers);
    void delete(Customers customers);
}
