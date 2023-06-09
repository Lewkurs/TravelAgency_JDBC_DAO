package Business_Aspects;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "EmployeeRoles")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeRoles {
    @XmlElement(name = "employeeRoleID")
    private int employeeRoleID;

    @XmlElement(name = "roleType")
    private String roleType;

    public int getEmployeeRoleID() {
        return employeeRoleID;
    }

    public void setEmployeeRoleID(int employeeRoleID) {
        this.employeeRoleID = employeeRoleID;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "EmployeeRoles [employeeRoleID=" + employeeRoleID + ", roleType=" + roleType + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof EmployeeRoles))
            return false;
        if (obj == this)
            return true;
        return this.getEmployeeRoleID() == ((EmployeeRoles) obj).getEmployeeRoleID();
    }

    @Override
    public int hashCode() {
        return this.getEmployeeRoleID();
    }
}

