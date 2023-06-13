package DAO;

import Business_Aspects.RolesEmployeeWorks;

import java.util.List;

public interface RolesEmployeeWorksDAO extends IDAO<RolesEmployeeWorks> {

            RolesEmployeeWorks create(RolesEmployeeWorks role); // Create a new role

            RolesEmployeeWorks getById(int roleID); // Get a role by its ID

            List<RolesEmployeeWorks> getAll(); // Get all roles

            RolesEmployeeWorks update(RolesEmployeeWorks role); // Update a role

            RolesEmployeeWorks delete(RolesEmployeeWorks role); // Delete a role
}
