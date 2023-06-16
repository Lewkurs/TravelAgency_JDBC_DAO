package Business_Aspects;

import java.util.Objects;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "DestinationBookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class DestinationBookings {
    @XmlElement(name = "destinationBookingID")
    private int destinationBookingID;

    @XmlElement(name = "destinationID")
    @JsonProperty("destinationID")
    private Destinations destinationID;

    @XmlElement(name = "bookingID")
    @JsonProperty("bookingID")
    private Bookings bookingID;

    public void setDestinationBookingID(int destinationBookingID) {
        this.destinationBookingID = destinationBookingID;
    }

    public int getDestinationBookingID() {
        return destinationBookingID;
    }

    public DestinationBookings(Destinations destinationID, Bookings bookingID) {
        this.destinationID = destinationID;
        this.bookingID = bookingID;
    }

    public Destinations getDestinationID() {
        return destinationID;
    }
    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
    }
    public Bookings getBookingID() {
        return bookingID;
    }
    public void setBookingID(Bookings bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String toString() {
        return "DestinationBookings [bookingID=" + bookingID + ", destinationID=" + destinationID + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof DestinationBookings))
            return false;
        DestinationBookings other = (DestinationBookings) obj;
        if (bookingID == null) {
            if (other.bookingID != null)
                return false;
        } else if (!bookingID.equals(other.bookingID))
            return false;
        if (destinationID == null) {
            if (other.destinationID != null)
                return false;
        } else if (!destinationID.equals(other.destinationID))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, destinationID);
    }

}
