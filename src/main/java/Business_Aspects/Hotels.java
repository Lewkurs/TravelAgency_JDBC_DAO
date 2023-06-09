package Business_Aspects;

public class Hotels {
    private int hotelsID;
    private String hotelName;
    private String address;
    private Destinations destinationsID;

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
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Destinations getDestinationsID() {
        return destinationsID;
    }

    public void setDestinationsID(Destinations destinationsID) {
        this.destinationsID = destinationsID;
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
