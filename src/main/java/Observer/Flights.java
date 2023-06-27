package Observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flights implements Observer {
    private static final Logger logger = LogManager.getLogger(Flights.class);

    @XmlElement(name = "flightsID")
    @JsonProperty("flightsID")
    private int flightsID;

    @XmlElement(name = "airline")
    @JsonProperty("airline")
    private String airline;

    @XmlElement(name = "departureCity")
    @JsonProperty("departureCity")
    private String departureCity;

    @XmlElement(name = "arrivalCity")
    @JsonProperty("arrivalCity")
    private String arrivalCity;

    @XmlElement(name = "departureTime")
    @JsonProperty("departureTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String departureTime;

    @XmlElement(name = "arrivalTime")
    @JsonProperty("arrivalTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String arrivalTime;

    // Observer update method
    @Override
    public void update() {
        logger.info("Flight {} from {} to {} has been booked.", flightsID, departureCity, arrivalCity);
    }

    public int getFlightsID() {
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
        if (obj == null)
            return false;
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
