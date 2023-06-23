package Service_Layer;

import Business_Aspects.Employees;
import DAO.EmployeesDAO;

import java.util.List;

public class EmployeesService {
    private EmployeesDAO employeesDAO;

    public EmployeesService(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    public Employees create(Employees employee) {
        return employeesDAO.create(employee);
    }

    public Employees getById(int id) {
        return employeesDAO.getById(id);
    }

    public List<Employees> getAll() {
        return employeesDAO.getAll();
    }

    public Employees update(Employees employee) {
        return employeesDAO.update(employee);
    }

    public Employees delete(Employees employee) {
        return employeesDAO.delete(employee);
    }
}
