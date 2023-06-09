package DAO;

import Business_Aspects.RolesEmployeeWorks;

import java.util.List;

public interface RolesEmployeeWorksDAO {
    List<RolesEmployeeWorks> getAllRolesEmployeeWorks();
    void save(RolesEmployeeWorks rolesEmployeeWorks);
    void update(RolesEmployeeWorks rolesEmployeeWorks);
    void delete(RolesEmployeeWorks rolesEmployeeWorks);
}
