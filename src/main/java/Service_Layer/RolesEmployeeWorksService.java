package Service_Layer;

import Business_Aspects.RolesEmployeeWorks;
import DAO.RolesEmployeeWorksDAO;

import java.util.List;

public class RolesEmployeeWorksService {
    private RolesEmployeeWorksDAO rolesEmployeeWorksDAO;

    public RolesEmployeeWorksService(RolesEmployeeWorksDAO rolesEmployeeWorksDAO) {
        this.rolesEmployeeWorksDAO = rolesEmployeeWorksDAO;
    }

    public List<RolesEmployeeWorks> getAllRolesEmployeeWorks() {
        return rolesEmployeeWorksDAO.getAllRolesEmployeeWorks();
    }

    public void saveRolesEmployeeWorks(RolesEmployeeWorks rolesEmployeeWorks) {
        rolesEmployeeWorksDAO.save(rolesEmployeeWorks);
    }

    public void updateRolesEmployeeWorks(RolesEmployeeWorks rolesEmployeeWorks) {
        rolesEmployeeWorksDAO.update(rolesEmployeeWorks);
    }

    public void deleteRolesEmployeeWorks(RolesEmployeeWorks rolesEmployeeWorks) {
        rolesEmployeeWorksDAO.delete(rolesEmployeeWorks);
    }
}
