package DAOImplementations;


import DAO.CustomersDAO;
import Business_Aspects.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO {

    private static final String INSERT_QUERY = "INSERT INTO customers(name, email, contact_number) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM customers WHERE customer_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM customers";
    private static final String UPDATE_QUERY = "UPDATE customers SET name = ?, email = ?, contact_number = ? WHERE customer_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM customers WHERE customer_id = ?";

    private Connection connection;

    public CustomersDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Customers create(Customers customer) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getContactNumber());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    customer.setCustomerID(generatedId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating customer: " + e.getMessage());
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customers getById(int customerID) {
        Customers customer = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customers();
                customer.setCustomerID(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setContactNumber(rs.getString("contact_number"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer: " + e.getMessage());
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customers> getAll() {
        List<Customers> customersList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customers customer = new Customers();
                customer.setCustomerID(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setContactNumber(rs.getString("contact_number"));
                customersList.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customers: " + e.getMessage());
            e.printStackTrace();
        }
        return customersList;
    }

    @Override
    public Customers update(Customers customer) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getContactNumber());
            ps.setInt(4, customer.getCustomerID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("Error updating customer: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customers delete(Customers customer) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, customer.getCustomerID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
