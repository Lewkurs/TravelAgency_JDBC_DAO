package Business_Aspects;

public class Flights {
    private static int flightsID;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private String departureTime;
    private String arrivalTime;

    public static int getFlightsID() {
        return flightsID;
    }

    public void setFlightsID(int flightsID) {
        this.flightsID = flightsID;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flights [flightsID=" + flightsID + ", airline=" + airline + ", departureCity=" + departureCity
                + ", arrivalCity=" + arrivalCity + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Flights))
            return false;
        if (obj == this)
            return true;
        return this.getFlightsID() == ((Flights) obj).getFlightsID();
    }

    @Override
    public int hashCode() {
        return this.getFlightsID();
    }
}

