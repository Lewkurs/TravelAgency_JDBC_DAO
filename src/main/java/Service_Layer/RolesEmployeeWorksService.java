package Service_Layer;

import Business_Aspects.RolesEmployeeWorks;
import DAO.RolesEmployeeWorksDAO;
import DAOImplementations.RolesEmployeeWorksDAOImpl;

import java.util.List;

import java.util.List;

public class RolesEmployeeWorksService {
    private RolesEmployeeWorksDAOImpl rolesEmployeeWorksDAO;

    public RolesEmployeeWorksService(RolesEmployeeWorksDAOImpl rolesEmployeeWorksDAO) {
        this.rolesEmployeeWorksDAO = rolesEmployeeWorksDAO;
    }

    public RolesEmployeeWorks create(RolesEmployeeWorks roleEmployeeWork) {
        return rolesEmployeeWorksDAO.create(roleEmployeeWork);
    }

    public RolesEmployeeWorks getById(int id) {
        return rolesEmployeeWorksDAO.getById(id);
    }

    public List<RolesEmployeeWorks> getAll() {
        return rolesEmployeeWorksDAO.getAll();
    }

    public RolesEmployeeWorks update(RolesEmployeeWorks roleEmployeeWork) {
        return rolesEmployeeWorksDAO.update(roleEmployeeWork);
    }

    public RolesEmployeeWorks delete(RolesEmployeeWorks roleEmployeeWork) {
        return rolesEmployeeWorksDAO.delete(roleEmployeeWork);
    }
}

