package Business_Aspects;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    @XmlElement(name = "employeeID")
    private int employeeID;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "phone")
    private String phone;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employees [employeeID=" + employeeID + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Employees))
            return false;
        if (obj == this)
            return true;
        return this.getEmployeeID() == ((Employees) obj).getEmployeeID();
    }

    @Override
    public int hashCode() {
        return this.getEmployeeID();
    }
}
