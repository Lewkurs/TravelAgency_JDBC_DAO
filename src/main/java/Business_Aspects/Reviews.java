package Business_Aspects;

public class Reviews {
    private int reviewsID;
    private int rating;
    private String reviewDescription;
    private Customers customerID;
    private Hotels hotelID;
    private Destinations destinationID;
    private Activities activityID;

    public int getReviewsID() {
        return reviewsID;
    }

    public void setReviewsID(int reviewsID) {
        this.reviewsID = reviewsID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public Hotels getHotelID() {
        return hotelID;
    }

    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
    }

    public Activities getActivityID() {
        return activityID;
    }

    public void setActivityID(Activities activityID) {
        this.activityID = activityID;
    }

    @Override
    public String toString() {
        return "Reviews [reviewsID=" + reviewsID + ", rating=" + rating + ", reviewDescription=" + reviewDescription
                + ", customerID=" + customerID + ", hotelID=" + hotelID + ", destinationID=" + destinationID
                + ", activityID=" + activityID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Reviews))
            return false;
        if (obj == this)
            return true;
        return this.getReviewsID() == ((Reviews) obj).getReviewsID();
    }

    @Override
    public int hashCode() {
        return this.getReviewsID();
    }
}
