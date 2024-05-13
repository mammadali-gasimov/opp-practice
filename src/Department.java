import java.util.Arrays;

public class Department {
    public int departmentNo;
    public String name;
    public int employeeCount;
    public Employee[] employeeList;

    public Department(int departmentNo, String name, int employeeCount) {
        this.departmentNo = departmentNo;
        this.name = name;
        this.employeeCount = employeeCount;
        this.employeeList = new Employee[employeeCount];
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentNo=" + departmentNo +
                ", name='" + name + '\'' +
                ", employeeCount=" + employeeCount +
                ", employeeList=" + Arrays.toString(employeeList) +
                '}';
    }
}
