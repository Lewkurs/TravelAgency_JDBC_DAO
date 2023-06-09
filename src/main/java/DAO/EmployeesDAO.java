package DAO;

import Business_Aspects.Employees;
import java.util.List;

public interface EmployeesDAO {
    Employees getEmployeesByID(int id);
    List<Employees> getAllEmployees();
    void save(Employees employees);
    void update(Employees employees);
    void delete(Employees employees);
}
