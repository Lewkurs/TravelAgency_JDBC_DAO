package Business_Aspects;

import java.util.Objects;

public class FlightBookings {
    private Flights flightID;
    private Bookings bookingID;

    public FlightBookings(Flights flightID, Bookings bookingID) {
        this.flightID = flightID;
        this.bookingID = bookingID;
    }

    public Flights getFlightID() {
        return flightID;
    }
    public void setFlightID(Flights flightID) {
        this.flightID = flightID;
    }
    public Bookings getBookingID() {
        return bookingID;
    }
    public void setBookingID(Bookings bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String toString() {
        return "FlightBookings [bookingID=" + bookingID + ", flightID=" + flightID + "]";
    }

    @Override
public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof FlightBookings))
            return false;
        FlightBookings other = (FlightBookings) obj;
        if (bookingID == null) {
            if (other.bookingID != null)
                return false;
        } else if (!bookingID.equals(other.bookingID))
            return false;
        if (flightID == null) {
            if (other.flightID != null)
                return false;
        } else if (!flightID.equals(other.flightID))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, flightID);
    }

}
