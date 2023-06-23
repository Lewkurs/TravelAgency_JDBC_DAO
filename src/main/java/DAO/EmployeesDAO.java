package DAO;

import Business_Aspects.Employees;
import java.util.List;

public interface EmployeesDAO extends IDAO<Employees> {

     Employees create(Employees employee); // Create a new employee

     Employees getById(int employeeID); // Get an employee by their ID

     List<Employees> getAll(); // Get all employees

     Employees update(Employees employee); // Update an employee

     Employees delete(Employees employee); // Delete an employee
}
