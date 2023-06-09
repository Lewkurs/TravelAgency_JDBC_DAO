package DAO;

import Business_Aspects.EmployeeRoles;
import java.util.List;

public interface EmployeeRolesDAO {
    EmployeeRoles getEmployeeRolesID(int id);
    List<EmployeeRoles> getAllEmployeeRoles();
    void save(EmployeeRoles employeeRoles);
    void update(EmployeeRoles employeeRoles);
    void delete(EmployeeRoles employeeRoles);
}
