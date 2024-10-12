package task.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcRunner {
    private static Scanner sc = new Scanner(System.in);
    private static JdbcTask jdbcTask = new JdbcTask();

    public static void main(String[] args) throws SQLException {
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
                    createDependentTable();
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
    }

    private static void createEmployeeTable() throws SQLException {
        jdbcTask.createTable();
        System.out.println("Employee table created successfully!");
    }

    private static void addEmployee() throws SQLException {
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Mobile: ");
            String mobile = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Department: ");
            String department = sc.nextLine();
            jdbcTask.insertEmployee(name, mobile, email, department);
        }
    }

    private static void getEmployeeByName() throws SQLException {
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        ResultSet rs = jdbcTask.getEmployeeByName(name);
        printEmployeeResultSet(rs);
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
    }

    private static void printFirstNEmployees() throws SQLException {
        System.out.print("Enter N: ");
        int n = Integer.parseInt(sc.nextLine());
        ResultSet rs = jdbcTask.printFirstNEmployees(n);
        printEmployeeResultSet(rs);
    }

    private static void printFirstNEmployeesAsc() throws SQLException {
        System.out.print("Enter N: ");
        int n = Integer.parseInt(sc.nextLine());
        ResultSet rs = jdbcTask.printFirstNEmployeesAsc(n);
        printEmployeeResultSet(rs);
    }

    private static void deleteEmployee() throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int empId = Integer.parseInt(sc.nextLine());
        jdbcTask.deleteEmployeeById(empId);
        System.out.println("Employee deleted successfully.");
    }

    private static void createDependentTable() throws SQLException {
        jdbcTask.createDependentTable();
        System.out.println("Dependent table created successfully!");
    }

    private static void addDependent() throws SQLException {
        System.out.print("Enter Employee ID: ");
        int empId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Dependent Name: ");
        String depName = sc.nextLine();
        System.out.print("Enter Dependent Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Relationship: ");
        String relationship = sc.nextLine();
        jdbcTask.insertDependent(empId, depName, age, relationship);
    }

    private static void getDependentsByEmployeeNameOrId() throws SQLException {
        System.out.print("Enter Employee Name or ID: ");
        String nameOrId = sc.nextLine();
        ResultSet rs = jdbcTask.getDependentsByEmployeeNameOrId(nameOrId);
        printDependentResultSet(rs);
    }

    private static void printDependentsForFirstNEmployees() throws SQLException {
        System.out.print("Enter N: ");
        int n = Integer.parseInt(sc.nextLine());
        ResultSet rs = jdbcTask.getDependentsForFirstNEmployees(n);
        printDependentResultSet(rs);
    }

    private static void printEmployeeResultSet(ResultSet rs) throws SQLException {
        System.out.printf("%-10s %-20s %-15s %-25s %-20s\n", "ID", "Name", "Mobile", "Email", "Department");
        while (rs.next()) {
            System.out.printf("%-10d %-20s %-15s %-25s %-20s\n",
                    rs.getInt("EMPLOYEE_ID"), rs.getString("NAME"),
                    rs.getString("MOBILE"), rs.getString("EMAIL"),
                    rs.getString("DEPARTMENT"));
        }
    }

    private static void printDependentResultSet(ResultSet rs) throws SQLException {
        System.out.printf("%-10s %-20s %-10s %-20s %-10s %-15s\n", "Emp ID", "Employee Name", "Dep ID", "Dep Name", "Age", "Relationship");
        while (rs.next()) {
            System.out.printf("%-10d %-20s %-10d %-20s %-10d %-15s\n",
                    rs.getInt("EMPLOYEE_ID"), rs.getString("NAME"),
                    rs.getInt("DEPENDENT_ID"), rs.getString("DEPENDENT_NAME"),
                    rs.getInt("AGE"), rs.getString("RELATIONSHIP"));
        }
    }
}
