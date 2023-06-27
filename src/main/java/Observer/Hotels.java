package Observer;

import Business_Aspects.Destinations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import jakarta.xml.bind.annotation.*;


@XmlRootElement(name = "Hotels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotels implements Observer {
    private static final Logger logger = LogManager.getLogger(Hotels.class);

    @XmlElement(name = "hotelsID")
    @JsonProperty("hotelsID")
    private int hotelsID;

    @XmlElement(name = "hotelName")
    @JsonProperty("hotelName")
    private String hotelName;

    @XmlElementWrapper(name = "address")
    @XmlElement(name = "line")
    @JsonProperty("address")
    private List<String> address;

    @XmlElementWrapper(name = "destinationsID")
    @XmlElement(name = "destination")
    @JsonProperty("destinationsID")
    private List<Destinations> destinationsID;

    // Observer update method
    @Override
    public void update() {
        logger.info("Hotel {} at address {} has been booked.", hotelsID, getAddress());
    }

    public int getHotelsID() {
        return hotelsID;
    }

    public void setHotelsID(int hotelsID) {
        this.hotelsID = hotelsID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address.toString();
    }

    public void setAddress(String address) {
        this.address = Collections.singletonList(address);
    }

    public List<Destinations> getDestinationsID() {
        return destinationsID;
    }

    public void setDestinationsID(List<Destinations> destinationsID) {
        this.destinationsID = destinationsID;
    }

    @Override
    public String toString() {
        return "Hotels [hotelsID=" + hotelsID + ", hotelName=" + hotelName + ", address=" + address
                + ", destinationsID=" + destinationsID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Hotels))
            return false;
        if (obj == this)
            return true;
        return this.getHotelsID() == ((Hotels) obj).getHotelsID();
    }

    @Override
    public int hashCode() {
        return this.getHotelsID();
    }
}
