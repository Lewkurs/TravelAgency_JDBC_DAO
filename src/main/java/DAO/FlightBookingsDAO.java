package DAO;

import Business_Aspects.FlightBookings;
import java.util.List;
public interface FlightBookingsDAO {
    List<FlightBookings> getAllFlightBookings();
    void save(FlightBookings flightBookings);
    void update(FlightBookings flightBookings);
    void delete(FlightBookings flightBookings);
}
