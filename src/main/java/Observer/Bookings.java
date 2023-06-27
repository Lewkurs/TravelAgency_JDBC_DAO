package Observer;

import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@XmlRootElement(name = "Bookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bookings implements Subject {
    // Observer pattern
    private List<Observer> observers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Bookings.class.getName());

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

    @XmlElement(name = "customerID")
    @JsonProperty("customerID")
    private Customer customerID;

    @XmlElement(name = "paymentID")
    @JsonProperty("paymentID")
    private Payments paymentID;

    @XmlElement(name = "flightID")
    @JsonProperty("flightID")
    private Flights flightID;

    @XmlElement(name = "hotelID")
    @JsonProperty("hotelID")
    private Hotels hotelID;


    private Customer customer;
    private Payments payment;
    private Hotels hotel;
    private Flights flight;

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

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Payments getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Payments paymentID) {
        this.paymentID = paymentID;
    }

    public Flights getFlightID() {
        return flightID;
    }

    public void setFlightID(Flights flightID) {
        this.flightID = flightID;
    }

    public Hotels getHotelID() {
        return hotelID;
    }

    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }

    public void attach(Observer o) {
        observers.add(o);
        logger.info("Observer attached: " + o.getClass().getSimpleName());
    }

    public void detach(Observer o) {
        observers.remove(o);
        logger.info("Observer detached: " + o.getClass().getSimpleName());
    }

    public void notifyUpdate() {
        for(Observer o: observers) {
            o.update();
        }
        logger.info("Observers notified.");
    }

    public void confirmBooking(Customer customer, Payments payment, Hotels hotel, Flights flight) {
        this.customer = customer;
        this.payment = payment;
        this.hotel = hotel;
        this.flight = flight;

        // Attach observers
        attach(customer);
        attach(payment);
        attach(hotel);
        attach(flight);

        // Notify all observers
        notifyUpdate();

        // Optionally, clear observers after the update if they are not needed anymore
        observers.clear();
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

