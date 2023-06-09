package Business_Aspects;

public class Transportation {
    private int transportationID;
    private String transportationType;
    private String description;
    private double pricePerHour;
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

