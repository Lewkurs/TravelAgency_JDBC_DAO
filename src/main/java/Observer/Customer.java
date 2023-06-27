package Observer;

import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.logging.Logger;


@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Observer {
    @XmlElement(name = "customerID")
    @JsonProperty("customerID")
    private int customerID;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;

    @XmlElement(name = "email")
    @JsonProperty("email")
    private String email;

    @XmlElement(name = "contactNumber")
    @JsonProperty("contactNumber")
    private String contactNumber;

    private static final Logger logger = Logger.getLogger(Customer.class.getName());

    // Observer method
    @Override
    public void update() {
        // Send an email or SMS or app notification to the customer.
        // For simplicity, this is simulated by logging
        logger.info("Customer " + this.name + " notified of the new booking via email/SMS/app.");
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", name=" + name + ", email=" + email + ", contactNumber="
                + contactNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Customer))
            return false;
        if (obj == this)
            return true;
        return this.getCustomerID() == ((Customer) obj).getCustomerID();
    }

    @Override
    public int hashCode() {
        return this.getCustomerID();
    }
}
