//$Id$
package task.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagementRunner {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeManagementTask employeeManagementTask = new EmployeeManagementTask();

    public void doEmployeeTasks() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    getEmployeeByName();
                    break;
                case 3:
                    getFirstNEmployees();
                    break;
                case 4:
                    getEmployeesSortedByName();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Employee Management System ---");
        System.out.println("1. Add Employee");
        System.out.println("2. Get Employee by Name");
        System.out.println("3. Get First N Employees");
        System.out.println("4. Get Employees Sorted by Name");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static void addEmployee() {
        Employee employee = new Employee();

        System.out.print("Enter Employee ID: ");
        employee.setEmployeeId(Integer.parseInt(sc.nextLine()));

        System.out.print("Enter Employee Name: ");
        employee.setName(sc.nextLine());

        System.out.print("Enter Mobile Number: ");
        employee.setMobile(sc.nextLine());

        System.out.print("Enter Email: ");
        employee.setEmail(sc.nextLine());

        System.out.print("Enter Department: ");
        employee.setDepartment(sc.nextLine());

        employeeManagementTask.addEmployee(employee);
    }

    private static void getEmployeeByName() {
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        List<Employee> employee = employeeManagementTask.getEmployeeByName(name);

        if (employee.size() != 0) {
            System.out.println("Employee found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void getFirstNEmployees() {
        System.out.print("Enter the number of employees to retrieve: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Employee> employees = employeeManagementTask.getFirstNEmployees(n);

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private static void getEmployeesSortedByName() {
        System.out.print("Enter the number of employees to retrieve: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Employee> employees = employeeManagementTask.getEmployeesSortedByName(n);

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}
