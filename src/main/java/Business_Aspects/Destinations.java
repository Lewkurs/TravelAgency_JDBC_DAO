package Business_Aspects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement(name = "Destinations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Destinations {
    @XmlElement(name = "destinationsID")
    private int destinationsID;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "price")
    private double price;
    public int getDestinationsID() {
        return destinationsID;
    }

    public void setDestinationsID(int destinationsID) {
        this.destinationsID = destinationsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Destinations [destinationsID=" + destinationsID + ", name=" + name + ", description=" + description + ", price=" + price + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Destinations))
            return false;
        if (obj == this)
            return true;
        return this.getDestinationsID() == ((Destinations) obj).getDestinationsID();
    }

    @Override
    public int hashCode() {
        return this.getDestinationsID();
    }
}

