public class Employee extends Person {
    public int employeeId;
    public double salary;
    public int experience;

    public Employee(String name, String surname, int age, int employeeId, double salary, int experience) {
        super(name, surname, age);
        this.employeeId = employeeId;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salary=" + salary +
                ", experience=" + experience +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
