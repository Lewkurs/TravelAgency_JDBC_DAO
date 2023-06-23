package DAOImplementations;

import DAO.FlightsDAO;
import Business_Aspects.Flights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsDAOImpl implements FlightsDAO {

    private static final String INSERT_QUERY = "INSERT INTO flights(airline, departure_city, arrival_city, departure_time, arrival_time) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM flights WHERE flight_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM flights";
    private static final String UPDATE_QUERY = "UPDATE flights SET airline=?, departure_city=?, arrival_city=?, departure_time=?, arrival_time=? WHERE flight_id=?";
    private static final String DELETE_QUERY = "DELETE FROM flights WHERE flight_id = ?";

    private Connection connection;

    public FlightsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Flights create(Flights flight) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, flight.getAirline());
            ps.setString(2, flight.getDepartureCity());
            ps.setString(3, flight.getArrivalCity());
            ps.setString(4, flight.getDepartureTime());
            ps.setString(5, flight.getArrivalTime());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    flight.setFlightsID(generatedKeys.getInt(1));
                    return flight;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating flight: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Flights getById(int flightID) {
        Flights flight = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, flightID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                flight = new Flights();
                flight.setFlightsID(rs.getInt("flight_id"));
                flight.setAirline(rs.getString("airline"));
                flight.setDepartureCity(rs.getString("departure_city"));
                flight.setArrivalCity(rs.getString("arrival_city"));
                flight.setDepartureTime(rs.getString("departure_time"));
                flight.setArrivalTime(rs.getString("arrival_time"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flight: " + e.getMessage());
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public List<Flights> getAll() {
        List<Flights> flightList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Flights flight = new Flights();
                flight.setFlightsID(rs.getInt("flight_id"));
                flight.setAirline(rs.getString("airline"));
                flight.setDepartureCity(rs.getString("departure_city"));
                flight.setArrivalCity(rs.getString("arrival_city"));
                flight.setDepartureTime(rs.getString("departure_time"));
                flight.setArrivalTime(rs.getString("arrival_time"));
                flightList.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flights: " + e.getMessage());
            e.printStackTrace();
        }
        return flightList;
    }

    @Override
    public Flights update(Flights flight) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, flight.getAirline());
            ps.setString(2, flight.getDepartureCity());
            ps.setString(3, flight.getArrivalCity());
            ps.setString(4, flight.getDepartureTime());
            ps.setString(5, flight.getArrivalTime());
            ps.setInt(6, flight.getFlightsID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return flight;
            }
        } catch (SQLException e) {
            System.out.println("Error updating flight: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Flights delete(Flights flight) {
        return null;
    }

    public int delete(int flightID) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, flightID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            System.out.println("Error deleting flight: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}