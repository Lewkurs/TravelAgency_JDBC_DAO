package DAOImplementations;

import DAO.EmployeesDAO;
import Business_Aspects.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAOImpl implements EmployeesDAO {

    private static final String INSERT_QUERY = "INSERT INTO employees(name, email, phone) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM employees WHERE employee_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM employees";
    private static final String UPDATE_QUERY = "UPDATE employees SET name = ?, email = ?, phone = ? WHERE employee_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM employees WHERE employee_id = ?";

    private Connection connection;

    public EmployeesDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Employees create(Employees employee) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhone());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    employee.setEmployeeID(generatedId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employees getById(int employeeID) {
        Employees employee = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                employee = new Employees();
                employee.setEmployeeID(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employees> getAll() {
        List<Employees> employeeList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployeeID(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employees update(Employees employee) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhone());
            ps.setInt(4, employee.getEmployeeID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return employee;
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employees delete(Employees employee) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, employee.getEmployeeID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return employee;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}