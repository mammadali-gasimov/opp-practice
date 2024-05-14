import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Department[] departmentList = new Department[0];

    public static void main(String[] args) {
        startProgram();
        while (true) {
            showMenu();
            getUserChoice();
        }
    }

    public static void showMenu() {
        System.out.println("Enter 1 to add employee by department number:");
        System.out.println("Enter 2 to remove employee by employee id:");
        System.out.println("Enter 3 to show all employees:");
        System.out.println("Enter 4 to show all employees by department number:");
        System.out.println("Enter 5 to search by employee name:");
        System.out.println("Enter 6 to search by employee name and department number:");
    }

    public static void getUserChoice() {
        int userChoice = scanner.nextInt();
        switch(userChoice) {
            case 1:
                System.out.println("Enter department number:");
                addEmployee(scanner.nextInt());
                break;
            case 2:
                System.out.println("Enter employee id:");
                removeEmployeeById(scanner.nextInt());
                break;
            case 3:
                showAllEmployees();
                break;
            case 4:
                System.out.println("Enter department number:");
                showAllEmployeesByDepartment(scanner.nextInt());
                break;
            case 5:
                scanner.nextLine();
                System.out.println("Enter employee name:");
                searchByEmployeeName(scanner.nextLine());
                break;
            case 6:
                scanner.nextLine();
                System.out.println("Enter employee name:");
                String name = scanner.nextLine();

                System.out.println("Enter department number:");
                int departmentNumber = scanner.nextInt();

                searchByEmployeeNameAndDepartmentNumber(name, departmentNumber);
                break;
        }
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

        for (Department department : departmentList) {
            if (department.departmentNo == departmentNumber) {
                isRightDepNumber = true;

                Employee[] employees = department.employeeList;
                for (int j = 0; j < employees.length; j++) {
                    if (employees[j] == null && employees.length <= department.employeeCount) {
                        System.out.println("Ishcinin adi:");
                        String name = scanner.nextLine();

                        System.out.println("Ishcinin soyadi:");
                        String surname = scanner.nextLine();

                        System.out.println("Ishichinin yashi:");
                        int age = scanner.nextInt();

                        System.out.println("Ishichinin id:");
                        int employeeId = scanner.nextInt();
                        while (!isUniqueEmployeeId(employeeId)) {
                            System.out.println("Ishichinin id:");
                            employeeId = scanner.nextInt();
                        }

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

        System.out.println(Arrays.toString(departmentList));
    }

    public static boolean isUniqueEmployeeId(int employeeId) {
        boolean isUnique = true;
        for (Department dep : departmentList) {
            for (Employee emp : dep.employeeList) {
                if (emp.employeeId == employeeId) {
                    isUnique = false;
                    break;
                }
            }
        }

        return  isUnique;
    }

    public static void removeEmployeeById(int employeeId) {
        boolean foundById = false;

        for (Department dep : departmentList) {
            Employee[] employees = new Employee[dep.employeeList.length - 1];
            for (int i = 0; i < dep.employeeList.length; i++) {
                if (dep.employeeList[i] != null && dep.employeeList[i].employeeId == employeeId) {
                    foundById = true;
                    dep.employeeList[i] = null;
                }
            }

            if (!foundById) {
                System.out.println("Employee was not found by provided id!");
                return;
            }

            for (int j = 0; j < dep.employeeList.length; j++) {
                int count = 0;
                if (dep.employeeList[j] != null) {
                    employees[count] = dep.employeeList[j];
                    count++;
                }
            }

            dep.employeeList = employees;
        }
    }

    public static void showAllEmployees() {
        for (Department dep: departmentList) {
            for (Employee emp : dep.employeeList) {
                System.out.println(emp.toString());
            }
        }
    }

    public static void showAllEmployeesByDepartment(int departmentId) {
        for (Department dep: departmentList) {
            if (dep.departmentNo == departmentId) {
                for (Employee emp : dep.employeeList) {
                    System.out.println(emp.toString());
                }
            }
        }
    }

    public static void searchByEmployeeName(String employeeName) {
        for (Department dep : departmentList) {
            for (Employee emp : dep.employeeList) {
                if (emp != null && emp.name.toLowerCase().contains(employeeName.toLowerCase())) {
                    System.out.println(emp.toString());
                }
            }
        }
    }

    public static void searchByEmployeeNameAndDepartmentNumber(String employeeName, int departmentNumber) {
        for (Department dep : departmentList) {
            if (dep.departmentNo == departmentNumber) {
                for (Employee emp : dep.employeeList) {
                    if (emp != null && emp.name.toLowerCase().contains(employeeName.toLowerCase())) {
                        System.out.println(emp.toString());
                    }
                }
                break;
            }
        }
    }
}