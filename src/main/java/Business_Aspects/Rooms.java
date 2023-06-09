package Business_Aspects;

public class Rooms {
    private int roomsID;
    private String roomType;
    private double pricePerNight;
    private boolean availability;
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

