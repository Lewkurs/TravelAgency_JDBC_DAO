package Business_Aspects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customers {
    @JsonProperty("customerID")
    private int customerID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("contactNumber")
    private String contactNumber;

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
        return "Customers [customerID=" + customerID + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Customers))
            return false;
        if (obj == this)
            return true;
        return this.getCustomerID() == ((Customers) obj).getCustomerID();
    }

    @Override
    public int hashCode() {
        return this.getCustomerID();
    }
}

