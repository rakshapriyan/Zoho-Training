package task.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JdbcRunner {
    private static Scanner sc = new Scanner(System.in);
    private static JdbcTask jdbcTask = new JdbcTask();
    private static EmployeeManagementRunner employeeManagementRunner = new EmployeeManagementRunner();

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Create Employee Table");
                System.out.println("2. Add Employee");
                System.out.println("3. Get Employee by Name");
                System.out.println("4. Update Employee Details");
                System.out.println("5. Print First N Employees");
                System.out.println("6. Print First N Employees (Sorted by Name)");
                System.out.println("7. Delete Employee");
                System.out.println("8. Create Dependent Table");
                System.out.println("9. Add Dependent for Employee");
                System.out.println("10. Get Dependents by Employee Name or ID");
                System.out.println("11. Print Dependents for First N Employees");
                System.out.println("0. Exit");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        createEmployeeTable();
                        break;
                    case 2:
                        addEmployee();
                        break;
                    case 3:
                        getEmployeeByName();
                        break;
                    case 4:
                        updateEmployeeDetails();
                        break;
                    case 5:
                        printFirstNEmployees();
                        break;
                    case 6:
                        printFirstNEmployeesAsc();
                        break;
                    case 7:
                        deleteEmployee();
                        break;
                    case 8:
                        employeeManagementRunner.doEmployeeTasks();
                        break;
                    case 9:
                        addDependent();
                        break;
                    case 10:
                        getDependentsByEmployeeNameOrId();
                        break;
                    case 11:
                        printDependentsForFirstNEmployees();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
            DBConfig.closeConnection();
        }
    }

    private static void createEmployeeTable() throws SQLException {
        jdbcTask.createTable();
        System.out.println("Employee table created successfully!");
    }

    private static void addEmployee() throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        jdbcTask.insertEmployee(name, mobile, email, department);
        System.out.println("Employee added successfully!");
    }

    private static void getEmployeeByName() throws SQLException {
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        List<Map<String, Object>> employees = jdbcTask.getEmployeeByName(name);
        printEmployeeList(employees);
    }

    private static void updateEmployeeDetails() throws SQLException {
        System.out.print("Enter Employee ID: ");
        int empId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new Mobile: ");
        String mobile = sc.nextLine();
        System.out.print("Enter new Email: ");
        String email = sc.nextLine();
        System.out.print("Enter new Department: ");
        String department = sc.nextLine();
        jdbcTask.updateEmployeeDetails(empId, mobile, email, department);
        System.out.println("Employee details updated successfully!");
    }

    private static void printFirstNEmployees() throws SQLException {
        System.out.print("Enter N: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Map<String, Object>> employees = jdbcTask.printFirstNEmployees(n);
        printEmployeeList(employees);
    }

    private static void printFirstNEmployeesAsc() throws SQLException {
        System.out.print("Enter N: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Map<String, Object>> employees = jdbcTask.printFirstNEmployeesAsc(n);
        printEmployeeList(employees);
    }

    private static void deleteEmployee() throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int empId = Integer.parseInt(sc.nextLine());
        jdbcTask.deleteEmployeeById(empId);
        System.out.println("Employee deleted successfully!");
    }

    private static void createDependentTable() throws SQLException {
        jdbcTask.createDependentTable();
        System.out.println("Dependent table created successfully!");
    }

    private static void addDependent() throws SQLException {
        System.out.print("Enter Employee ID: ");
        int empId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Dependent Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Relationship: ");
        String relationship = sc.nextLine();
        jdbcTask.insertDependent(empId, name, age, relationship);
        System.out.println("Dependent added successfully!");
    }

    private static void getDependentsByEmployeeNameOrId() throws SQLException {
        System.out.print("Enter Employee Name or ID: ");
        String input = sc.nextLine();
        List<Map<String, Object>> dependents = jdbcTask.getDependentsByEmployeeNameOrId(input);
        printDependentList(dependents);
    }

    private static void printDependentsForFirstNEmployees() throws SQLException {
        System.out.print("Enter N: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Map<String, Object>> dependents = jdbcTask.getDependentsForFirstNEmployees(n);
        printDependentList(dependents);
    }

    private static void printEmployeeList(List<Map<String, Object>> employees) {
        System.out.println("Employees:");
        for (Map<String, Object> employee : employees) {
            System.out.println(employee);
        }
    }

    private static void printDependentList(List<Map<String, Object>> dependents) {
        System.out.println("Dependents:");
        for (Map<String, Object> dependent : dependents) {
            System.out.println(dependent);
        }
    }
}
