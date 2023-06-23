package DAO;

import Business_Aspects.EmployeeRoles;
import java.util.List;

public interface EmployeeRolesDAO extends IDAO<EmployeeRoles> {

     EmployeeRoles create(EmployeeRoles employeeRole); // Create a new employeeRole

     EmployeeRoles getById(int employeeRoleID); // Get a employeeRole by its ID

     List<EmployeeRoles> getAll(); // Get all employeeRoles

     EmployeeRoles update(EmployeeRoles employeeRole); // Update a employeeRole

     EmployeeRoles delete(EmployeeRoles employeeRole); // Delete a employeeRole
}
