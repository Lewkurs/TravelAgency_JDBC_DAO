package Business_Aspects;

import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Activity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Activities {
    @XmlElement(name = "ActivityID")
    @JsonProperty("ActivityID")
    private int activityID;

    @XmlElement(name = "ActivityName")
    @JsonProperty("ActivityName")
    private String activityName;

    @XmlElement(name = "ActivityDescription")
    @JsonProperty("ActivityDescription")
    private String activityDescription;

    @XmlElement(name = "ActivityPrice")
    @JsonProperty("ActivityPrice")
    private String activityPrice;

    @XmlElement(name = "DestinationID")
    @JsonProperty("DestinationID")
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

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
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
