package Service_Layer;

import Business_Aspects.EmployeeRoles;
import DAO.EmployeeRolesDAO;

import java.util.List;

public class EmployeeRolesService {
    private EmployeeRolesDAO employeeRolesDAO;

    public EmployeeRolesService(EmployeeRolesDAO employeeRolesDAO) {
        this.employeeRolesDAO = employeeRolesDAO;
    }

    public List<EmployeeRoles> getAllEmployeeRoles() {
        return employeeRolesDAO.getAllEmployeeRoles();
    }

    public void saveEmployeeRole(EmployeeRoles employeeRole) {
        employeeRolesDAO.save(employeeRole);
    }

    public void updateEmployeeRole(EmployeeRoles employeeRole) {
        employeeRolesDAO.update(employeeRole);
    }

    public void deleteEmployeeRole(EmployeeRoles employeeRole) {
        employeeRolesDAO.delete(employeeRole);
    }
}

