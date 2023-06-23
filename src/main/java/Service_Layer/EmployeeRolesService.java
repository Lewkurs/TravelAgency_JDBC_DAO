package Service_Layer;

import Business_Aspects.EmployeeRoles;
import DAO.EmployeeRolesDAO;

import java.util.List;

public class EmployeeRolesService {
    private EmployeeRolesDAO employeeRolesDAO;

    public EmployeeRolesService(EmployeeRolesDAO employeeRolesDAO) {
        this.employeeRolesDAO = employeeRolesDAO;
    }

    public EmployeeRoles create(EmployeeRoles employeeRole) {
        return employeeRolesDAO.create(employeeRole);
    }

    public EmployeeRoles getById(int id) {
        return employeeRolesDAO.getById(id);
    }

    public List<EmployeeRoles> getAll() {
        return employeeRolesDAO.getAll();
    }

    public EmployeeRoles update(EmployeeRoles employeeRole) {
        return employeeRolesDAO.update(employeeRole);
    }

    public EmployeeRoles delete(EmployeeRoles employeeRole) {
        return employeeRolesDAO.delete(employeeRole);
    }
}
