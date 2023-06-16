package Business_Aspects;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rooms {
    @XmlElement(name = "roomsID")
    @JsonProperty("roomsID")
    private int roomsID;

    @XmlElement(name = "roomType")
    @JsonProperty("roomType")
    private String roomType;

    @XmlElement(name = "pricePerNight")
    @JsonProperty("pricePerNight")
    private double pricePerNight;

    @XmlElement(name = "availability")
    @JsonProperty("availability")
    private boolean availability;

    @XmlElement(name = "hotelID")
    @JsonProperty("hotelID")
    private Hotels hotelID;

    public int getRoomsID() {
        return roomsID;
    }

    public void setRoomsID(int roomsID) {
        this.roomsID = roomsID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Hotels getHotelID() {
        return hotelID;
    }

    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }

    @Override
    public String toString() {
        return "Rooms [roomsID=" + roomsID + ", roomType=" + roomType + ", pricePerNight=" + pricePerNight
                + ", availability=" + availability + ", hotelID=" + hotelID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Rooms))
            return false;
        if (obj == this)
            return true;
        return this.getRoomsID() == ((Rooms) obj).getRoomsID();
    }

    @Override
    public int hashCode() {
        return this.getRoomsID();
    }
}

