package Business_Aspects;

import java.util.Objects;

public class RolesEmployeeWorks {
    private EmployeeRoles role;
    private Employees employee;

    public RolesEmployeeWorks(EmployeeRoles role, Employees employee) {
        this.role = role;
        this.employee = employee;
    }

    public EmployeeRoles getRole() {
        return role;
    }
    public void setRole(EmployeeRoles role) {
        this.role = role;
    }
    public Employees getEmployee() {
        return employee;
    }
    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "RolesEmployeeWorks [employee=" + employee + ", role=" + role + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof RolesEmployeeWorks))
            return false;
        RolesEmployeeWorks other = (RolesEmployeeWorks) obj;
        if (employee == null) {
            if (other.employee != null)
                return false;
        } else if (!employee.equals(other.employee))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, role);
    }
}
