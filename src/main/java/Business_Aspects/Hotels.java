package Business_Aspects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class Hotels {
    @JsonProperty ("hotelsID")
    private int hotelsID;
    @JsonProperty ("hotelName")
    private String hotelName;
    @JsonProperty ("address")
    private List<String> address;
    @JsonProperty ("destinationsID")
    private List<Destinations> destinationsID;

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

    public Destinations getDestinationsID() {
        return (Destinations) destinationsID;
    }

    public void setDestinationsID(Destinations destinationsID) {
        this.destinationsID = (List<Destinations>) destinationsID;
    }

    @Override
    public String toString() {
        return "Hotels [hotelsID=" + hotelsID + ", hotelName=" + hotelName + ", address=" + address
                + ", destinationsID=" + destinationsID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
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
