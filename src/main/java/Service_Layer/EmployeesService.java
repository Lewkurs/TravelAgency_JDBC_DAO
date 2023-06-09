package Service_Layer;

import Business_Aspects.Employees;
import DAO.EmployeesDAO;

import java.util.List;

public class EmployeesService {
    private EmployeesDAO employeesDAO;

    public EmployeesService(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    public Employees getEmployeeByID(int id) {
        return employeesDAO.getEmployeesByID(id);
    }

    public List<Employees> getAllEmployees() {
        return employeesDAO.getAllEmployees();
    }

    public void saveEmployee(Employees employee) {
        employeesDAO.save(employee);
    }

    public void updateEmployee(Employees employee) {
        employeesDAO.update(employee);
    }

    public void deleteEmployee(Employees employee) {
        employeesDAO.delete(employee);
    }
}
