package Business_Aspects;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Transportation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transportation {
    @XmlElement(name = "transportationID")
    @JsonProperty("transportationID")
    private int transportationID;

    @XmlElement(name = "transportationType")
    @JsonProperty("transportationType")
    private String transportationType;

    @XmlElement(name = "description")
    @JsonProperty("description")
    private String description;

    @XmlElement(name = "pricePerHour")
    @JsonProperty("pricePerHour")
    private double pricePerHour;

    @XmlElement(name = "destinationID")
    @JsonProperty("destinationID")
    private Destinations destinationID;

    public int getTransportationID() {
        return transportationID;
    }

    public void setTransportationID(int transportationID) {
        this.transportationID = transportationID;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
    }

    @Override
    public String toString() {
        return "Transportation [transportationID=" + transportationID + ", transportationType=" + transportationType
                + ", description=" + description + ", pricePerHour=" + pricePerHour + ", destinationID=" + destinationID
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Transportation))
            return false;
        if (obj == this)
            return true;
        return this.getTransportationID() == ((Transportation) obj).getTransportationID();
    }

    @Override
    public int hashCode() {
        return this.getTransportationID();
    }
}

