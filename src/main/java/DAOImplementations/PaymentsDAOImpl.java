package DAOImplementations;

import DAO.PaymentsDAO;
import Business_Aspects.Payments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAOImpl implements PaymentsDAO {

    private static final String INSERT_QUERY = "INSERT INTO payments(payment_method, payment_amount) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM payments WHERE payment_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM payments";
    private static final String UPDATE_QUERY = "UPDATE payments SET payment_method=?, payment_amount=? WHERE payment_id=?";
    private static final String DELETE_QUERY = "DELETE FROM payments WHERE payment_id = ?";

    private Connection connection;

    public PaymentsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Payments create(Payments payment) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, payment.getPaymentMethod());
            ps.setDouble(2, payment.getPaymentAmount());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    payment.setPaymentsID(generatedKeys.getInt(1));
                }
                return payment;
            }
        } catch (SQLException e) {
            System.out.println("Error creating payment: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Payments getById(int paymentID) {
        Payments payment = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, paymentID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                payment = new Payments();
                payment.setPaymentsID(rs.getInt("payment_id"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPaymentAmount(rs.getDouble("payment_amount"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving payment: " + e.getMessage());
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public List<Payments> getAll() {
        List<Payments> paymentList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Payments payment = new Payments();
                payment.setPaymentsID(rs.getInt("payment_id"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPaymentAmount(rs.getDouble("payment_amount"));
                paymentList.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving payments: " + e.getMessage());
            e.printStackTrace();
        }
        return paymentList;
    }

    @Override
    public Payments update(Payments payment) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, payment.getPaymentMethod());
            ps.setDouble(2, payment.getPaymentAmount());
            ps.setInt(3, payment.getPaymentsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return payment;
            }
        } catch (SQLException e) {
            System.out.println("Error updating payment: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Payments delete(Payments paymentID) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, paymentID.getPaymentsID());

            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row/s deleted.");
            if (rowsAffected > 0) {
                System.out.println("Payment with ID: " + paymentID + " deleted successfully");
            } else {
                System.out.println("No payment with ID: " + paymentID + " found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting payment: " + e.getMessage());
            e.printStackTrace();
        }
        return paymentID;
    }
}