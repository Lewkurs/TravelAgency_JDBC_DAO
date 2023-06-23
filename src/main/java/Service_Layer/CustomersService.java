package Service_Layer;

import Business_Aspects.Customers;
import DAO.CustomersDAO;

import java.util.List;

public class CustomersService {
    private CustomersDAO customersDAO;

    public CustomersService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public Customers create(Customers customer) {
        return customersDAO.create(customer);
    }

    public Customers getById(int id) {
        return customersDAO.getById(id);
    }

    public List<Customers> getAll() {
        return customersDAO.getAll();
    }

    public Customers update(Customers customer) {
        return customersDAO.update(customer);
    }

    public Customers delete(Customers customer) {
        return customersDAO.delete(customer);
    }
}
