import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Department[] departmentList = new Department[0];

    public static void main(String[] args) {
        startProgram();
    }

    public static void showMenu() {
        System.out.println();
    }

    public static void startProgram() {
        System.out.println("Nece department yaratmaq isteyirsiniz?");
        int departCount = scanner.nextInt();
        while (departCount <= 0) {
            System.out.println("Nece department yaratmaq isteyirsiniz?");
            departCount = scanner.nextInt();
        }
        departmentList = new Department[departCount];
        int counter = 0;
        while (counter < departCount) {
            addDepartment();
            counter++;
        }
    }

    public static void addDepartment() {
        System.out.println("Department nomresi:");
        int departmentNumber = scanner.nextInt();

        for (Department dep : departmentList) {
            while (dep != null && dep.departmentNo == departmentNumber) {
                System.out.println("Department number yunik olmalidi!");
                System.out.println("Department nomresi:");
                departmentNumber = scanner.nextInt();
            }
        }

        System.out.println("Departmentde olacaq ishci sayi:");
        int employeeCount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Department adi:");
        String departmentName = scanner.nextLine();

        for (int i = 0; i < departmentList.length; i++) {
            if (departmentList[i] == null) {
                departmentList[i] = new Department(departmentNumber, departmentName, employeeCount);
                break;
            }
        }

        System.out.println(Arrays.toString(departmentList));
    }

    public static void addEmployee(int departmentNumber) {
        boolean isRightDepNumber = false;

        for (int i = 0; i < departmentList.length; i++) {
            if (departmentList[i].departmentNo == departmentNumber) {
                isRightDepNumber = true;

                Employee[] employees = departmentList[i].employeeList;
                for (int j = 0; j < employees.length; j++) {
                    if (employees[j] == null && employees.length <= departmentList[i].employeeCount) {
                        System.out.println("Ishcinin adi:");
                        String name = scanner.nextLine();

                        System.out.println("Ishcinin soyadi:");
                        String surname = scanner.nextLine();

                        System.out.println("Ishichinin yashi:");
                        int age = scanner.nextInt();

                        System.out.println("Ishichinin id:");
                        int employeeId = scanner.nextInt();

                        System.out.println("Ishichinin masshi:");
                        double salary = scanner.nextDouble();

                        System.out.println("Ishichinin tecrubesi:");
                        int experience = scanner.nextInt();

                        employees[j] = new Employee(name, surname, age, employeeId, salary, experience);
                    }
                }
            }
        }

        if (!isRightDepNumber) {
            System.out.println("Department tapilmadi!");
        }
    }
}