package DAOImplementations;

import Business_Aspects.EmployeeRoles;
import Business_Aspects.Employees;
import DAO.RolesEmployeeWorksDAO;
import Business_Aspects.RolesEmployeeWorks;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RolesEmployeeWorksDAOImpl implements RolesEmployeeWorksDAO {

    private static final String INSERT_QUERY = "INSERT INTO roles_employee_works(role_id, employee_id) VALUES (?, ?)";
    private static final String SELECT_BY_ROLE_QUERY = "SELECT * FROM roles_employee_works WHERE role_id = ?";
    private static final String SELECT_BY_EMPLOYEE_QUERY = "SELECT * FROM roles_employee_works WHERE employee_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM roles_employee_works";
    private static final String UPDATE_QUERY = "UPDATE roles_employee_works SET role_id = ?, employee_id = ? WHERE role_id = ? AND employee_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM roles_employee_works WHERE role_id = ? AND employee_id = ?";

    private Connection connection;
    private static final Logger logger = Logger.getLogger(RolesEmployeeWorksDAOImpl.class.getName());

    public RolesEmployeeWorksDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public RolesEmployeeWorks create(RolesEmployeeWorks rolesEmployeeWorks) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, rolesEmployeeWorks.getRole().getEmployeeRoleID());
            ps.setInt(2, rolesEmployeeWorks.getEmployee().getEmployeeID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return rolesEmployeeWorks;
            }
        } catch (SQLException e) {
            logger.severe("Error creating roles_employee_works: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RolesEmployeeWorks getById(int roleID) {
        return null;
    }

    @Override
    public RolesEmployeeWorks update(RolesEmployeeWorks rolesEmployeeWorks) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setInt(1, rolesEmployeeWorks.getRole().getEmployeeRoleID());
            ps.setInt(2, rolesEmployeeWorks.getEmployee().getEmployeeID());
            ps.setInt(3, rolesEmployeeWorks.getRole().getEmployeeRoleID());
            ps.setInt(4, rolesEmployeeWorks.getEmployee().getEmployeeID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return rolesEmployeeWorks;
            }
        } catch (SQLException e) {
            logger.severe("Error updating roles_employee_works: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<RolesEmployeeWorks> getById(Employees employee) {
        List<RolesEmployeeWorks> rolesEmployeeWorksList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_EMPLOYEE_QUERY)) {
            ps.setInt(1, employee.getEmployeeID());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RolesEmployeeWorks rolesEmployeeWorks = new RolesEmployeeWorks(new EmployeeRoles(), new Employees());

                EmployeeRoles role = new EmployeeRoles();
                role.setEmployeeRoleID(rs.getInt("role_id"));
                rolesEmployeeWorks.setRole(role);
                rolesEmployeeWorks.setEmployee(employee);

                rolesEmployeeWorksList.add(rolesEmployeeWorks);
            }
        } catch (SQLException e) {
            logger.severe("Error retrieving roles_employee_works: " + e.getMessage());
            e.printStackTrace();
        }
        return rolesEmployeeWorksList;
    }

    @Override
    public List<RolesEmployeeWorks> getAll() {
        List<RolesEmployeeWorks> rolesEmployeeWorksList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RolesEmployeeWorks rolesEmployeeWorks = new RolesEmployeeWorks(null, null);

                EmployeeRoles role = new EmployeeRoles();
                role.setEmployeeRoleID(rs.getInt("role_id"));
                rolesEmployeeWorks.setRole(role);
                Employees employee = new Employees();
                employee.setEmployeeID(rs.getInt("employee_id"));
                rolesEmployeeWorks.setEmployee(employee);

                rolesEmployeeWorksList.add(rolesEmployeeWorks);
            }
        } catch (SQLException e) {
            logger.severe("Error retrieving roles_employee_works: " + e.getMessage());
            e.printStackTrace();
        }
        return rolesEmployeeWorksList;
    }

    @Override
    public RolesEmployeeWorks delete(RolesEmployeeWorks rolesEmployeeWorks) {
        int roleID = rolesEmployeeWorks.getRole().getEmployeeRoleID();
        int employeeID = rolesEmployeeWorks.getEmployee().getEmployeeID();
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, roleID);
            ps.setInt(2, employeeID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("RolesEmployeeWorks with Role ID: " + roleID + " and Employee ID: " + employeeID + " deleted successfully");
            } else {
                logger.info("No RolesEmployeeWorks with Role ID: " + roleID + " and Employee ID: " + employeeID + " found");
            }
        } catch (SQLException e) {
            logger.severe("Error deleting RolesEmployeeWorks: " + e.getMessage());
            e.printStackTrace();
        }
        return rolesEmployeeWorks;
    }
}
