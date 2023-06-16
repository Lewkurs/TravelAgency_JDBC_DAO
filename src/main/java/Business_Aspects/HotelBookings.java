package Business_Aspects;

import java.util.Objects;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "HotelBookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelBookings {
    @XmlElement(name = "hotelID")
    private Hotels hotelID;

    @XmlElement(name = "bookingID")
    private Bookings bookingID;

    public HotelBookings (Hotels hotelID, Bookings bookingID) {
        this.hotelID = hotelID;
        this.bookingID = bookingID;
    }

    public Hotels getHotelID() {
        return hotelID;
    }
    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }
    public Bookings getBookingID() {
        return bookingID;
    }
    public void setBookingID(Bookings bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String toString() {
        return "HotelBookings [bookingID=" + bookingID + ", hotelID=" + hotelID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof HotelBookings))
            return false;
        HotelBookings other = (HotelBookings) obj;
        if (bookingID == null) {
            if (other.bookingID != null)
                return false;
        } else if (!bookingID.equals(other.bookingID))
            return false;
        if (hotelID == null) {
            if (other.hotelID != null)
                return false;
        } else if (!hotelID.equals(other.hotelID))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, hotelID);
    }
}
