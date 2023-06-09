package Service_Layer;

import DAO.CustomersDAO;
import Business_Aspects.Customers;

import java.util.List;

public class CustomersService {
    private CustomersDAO customersDAO;

    public CustomersService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public Customers getCustomerByID(int id) {
        return customersDAO.getCustomerByID(id);
    }

    public List<Customers> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }

    public void saveCustomer(Customers customer) {
        customersDAO.save(customer);
    }

    public void updateCustomer(Customers customer) {
        customersDAO.update(customer);
    }

    public void deleteCustomer(Customers customer) {
        customersDAO.delete(customer);
    }
}
