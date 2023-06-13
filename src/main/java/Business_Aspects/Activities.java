package Business_Aspects;

public class Activities {
    private int activityID;
    private String activityName;
    private String activityDescription;
    private String activityPrice;
    private Destinations destinationID;

    public Activities(int activityID, String activityName, String activityDescription, String activityPrice, Destinations destinationID) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.activityPrice = activityPrice;
        this.destinationID = destinationID;
    }
    public int getActivityID() {
        return activityID;
    }
    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public String getActivityDescription() {
        return activityDescription;
    }
    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }
    public String getActivityPrice() {
        return activityPrice;
    }
    public void setActivityPrice(String activityPrice) {
        this.activityPrice = activityPrice;
    }
    public Destinations getDestination() {
        return destinationID;
    }
    public void setDestination(Destinations destinationID) {
        this.destinationID = destinationID;
    }

    @Override
    public String toString() {
        return "Activities [activityID=" + activityID + ", activityName=" + activityName + ", activityDescription="
                + activityDescription + ", activityPrice=" + activityPrice + ", destinationID=" + destinationID + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Activities))
            return false;
        if (obj == this)
            return true;
        return this.getActivityID() == ((Activities) obj).getActivityID();
    }

    @Override
    public int hashCode() {
        return this.getActivityID();
    }


}
