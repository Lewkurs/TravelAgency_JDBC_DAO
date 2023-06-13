package DAOImplementations;

import DAO.EmployeeRolesDAO;
import Business_Aspects.EmployeeRoles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRolesDAOImpl implements EmployeeRolesDAO {

    private static final String INSERT_QUERY = "INSERT INTO employee_roles(role_type) VALUES (?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM employee_roles WHERE employee_role_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM employee_roles";
    private static final String UPDATE_QUERY = "UPDATE employee_roles SET role_type = ? WHERE employee_role_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM employee_roles WHERE employee_role_id = ?";

    private Connection connection;

    public EmployeeRolesDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public EmployeeRoles create(EmployeeRoles employeeRole) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, employeeRole.getRoleType());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    employeeRole.setEmployeeRoleID(generatedId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating employee role: " + e.getMessage());
            e.printStackTrace();
        }
        return employeeRole;
    }

    @Override
    public EmployeeRoles getById(int employeeRoleID) {
        EmployeeRoles employeeRole = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, employeeRoleID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                employeeRole = new EmployeeRoles();
                employeeRole.setEmployeeRoleID(rs.getInt("employee_role_id"));
                employeeRole.setRoleType(rs.getString("role_type"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee role: " + e.getMessage());
            e.printStackTrace();
        }
        return employeeRole;
    }

    @Override
    public List<EmployeeRoles> getAll() {
        List<EmployeeRoles> employeeRoleList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeRoles employeeRole = new EmployeeRoles();
                employeeRole.setEmployeeRoleID(rs.getInt("employee_role_id"));
                employeeRole.setRoleType(rs.getString("role_type"));
                employeeRoleList.add(employeeRole);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee roles: " + e.getMessage());
            e.printStackTrace();
        }
        return employeeRoleList;
    }

    public EmployeeRoles save(EmployeeRoles employeeRoles) {
        return null;
    }

    @Override
    public EmployeeRoles update(EmployeeRoles employeeRole) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, employeeRole.getRoleType());
            ps.setInt(2, employeeRole.getEmployeeRoleID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return employeeRole;
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee role: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeRoles delete(EmployeeRoles employeeRole) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, employeeRole.getEmployeeRoleID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return employeeRole;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee role: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
