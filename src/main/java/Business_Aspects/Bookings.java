package Business_Aspects;

import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Bookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bookings {
    @XmlElement(name = "bookingID")
    @JsonProperty("bookingID")
    private int bookingID;

    @XmlElement(name = "bookingDate")
    @JsonProperty("bookingDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String bookingDate;

    @XmlElement(name = "totalCost")
    @JsonProperty("totalCost")
    private double totalCost;

    @XmlElementWrapper(name = "customerIDs")
    @XmlElement(name = "customerID")
    @JsonProperty("customerID")
    private List<Customers> customerID;

    @XmlElementWrapper(name = "paymentIDs")
    @XmlElement(name = "paymentID")
    @JsonProperty("paymentID")
    private List<Payments> paymentID;

    @XmlElementWrapper(name = "flightIDs")
    @XmlElement(name = "flightID")
    @JsonProperty("flightID")
    private List<Flights> flightID;

    @XmlElementWrapper(name = "hotelIDs")
    @XmlElement(name = "hotelID")
    @JsonProperty("hotelID")
    private List<Hotels> hotelID;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<Customers> getCustomerID() {
        return customerID;
    }

    public void setCustomerID(List<Customers> customerID) {
        this.customerID = customerID;
    }

    public List<Payments> getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(List<Payments> paymentID) {
        this.paymentID = paymentID;
    }

    public List<Flights> getFlightID() {
        return flightID;
    }

    public void setFlightID(List<Flights> flightID) {
        this.flightID = flightID;
    }

    public List<Hotels> getHotelID() {
        return hotelID;
    }

    public void setHotelID(List<Hotels> hotelID) {
        this.hotelID = hotelID;
    }

    @Override
    public String toString() {
        return "Bookings [bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", totalCost=" + totalCost
                + ", customerID=" + customerID + ", paymentID=" + paymentID + ", flightID=" + flightID + ", hotelID="
                + hotelID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Bookings))
            return false;
        if (obj == this)
            return true;
        return this.getBookingID() == ((Bookings) obj).getBookingID();
    }

    @Override
    public int hashCode() {
        return this.getBookingID();
    }
}
