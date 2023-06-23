package Service_Layer;

import Business_Aspects.RolesEmployeeWorks;
import DAO.RolesEmployeeWorksDAO;

import java.util.List;

public class RolesEmployeeWorksService {
    private RolesEmployeeWorksDAO rolesEmployeeWorksDAO;

    public RolesEmployeeWorksService(RolesEmployeeWorksDAO rolesEmployeeWorksDAO) {
        this.rolesEmployeeWorksDAO = rolesEmployeeWorksDAO;
    }

    public RolesEmployeeWorks create(RolesEmployeeWorks role) {
        return rolesEmployeeWorksDAO.create(role);
    }

    public RolesEmployeeWorks getById(int id) {
        return rolesEmployeeWorksDAO.getById(id);
    }

    public List<RolesEmployeeWorks> getAll() {
        return rolesEmployeeWorksDAO.getAll();
    }

    public RolesEmployeeWorks update(RolesEmployeeWorks role) {
        return rolesEmployeeWorksDAO.update(role);
    }

    public RolesEmployeeWorks delete(RolesEmployeeWorks role) {
        return rolesEmployeeWorksDAO.delete(role);
    }
}
