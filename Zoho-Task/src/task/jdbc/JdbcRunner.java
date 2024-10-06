package task.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcRunner {
	
	private static Scanner sc = new Scanner(System.in);
	private static JdbcTask jdbcTask = new JdbcTask();
	public static void main(String[] args) {
		
		
	}
	
	
	private void createEmployeeTable() throws SQLException {
				jdbcTask.createTable();
	            System.out.println("Employee table created successfully!");
	}
	
	
	
	
	private void addNUser() throws SQLException {
		boolean continueAdding = true;
		while (continueAdding) {
            System.out.println("Enter Employee details:");

            System.out.print("Employee ID: ");
            int empId = Integer.parseInt(sc.nextLine()); 

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Mobile: ");
            String mobile = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            jdbcTask.insertEmployee( empId, name, mobile, email, department);

            System.out.print("Do you want to add another employee? (yes/no): ");
            String response = sc.nextLine();
            continueAdding = response.equalsIgnoreCase("yes");
        }
	}
	
	
	private void getEmployeeByName() throws SQLException {
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
		
        ResultSet rs = jdbcTask.getEmployeeByName(name);
        if (!rs.isBeforeFirst()) {
            System.out.println("No employee found with the name: " + name);
            return;
        }

        while (rs.next()) {
            int empId = rs.getInt("EMPLOYEE_ID");
            String empName = rs.getString("NAME");
            String mobile = rs.getString("MOBILE");
            String email = rs.getString("EMAIL");
            String department = rs.getString("DEPARTMENT");

            System.out.println("Employee ID: " + empId);
            System.out.println("Name: " + empName);
            System.out.println("Mobile: " + mobile);
            System.out.println("Email: " + email);
            System.out.println("Department: " + department);
            System.out.println("--------------------------------------------------");

        }
	}
	
	
	
	private void updateEmployeeDetails() throws SQLException {
		System.out.print("Enter Employee ID to update: ");
        int empId = Integer.parseInt(sc.nextLine());

        // Get updated details from user
        System.out.print("Enter new Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Enter new Email: ");
        String email = sc.nextLine();

        System.out.print("Enter new Department: ");
        String department = sc.nextLine();
        
        
        
        
        
        int rowsUpdated = jdbcTask.updateEmployeeDetails( empId, mobile, email, department);
        if (rowsUpdated > 0) {
            System.out.println("Employee details updated successfully!");
        } else {
            System.out.println("No employee found with ID: " + empId);
        }
	}
	
	
	
	public void printFirstNUsers() throws SQLException {
		System.out.print("Enter the number of employees to fetch: ");
        int n = Integer.parseInt(sc.nextLine());
        ResultSet rs = jdbcTask.printFirstNEmployees(n);
        
        System.out.println("EMPLOYEE_ID | NAME       | MOBILE      | EMAIL               | DEPARTMENT");
        System.out.println("-----------------------------------------------------------------------");
        while (rs.next()) {
            int empId = rs.getInt("EMPLOYEE_ID");
            String name = rs.getString("NAME");
            String mobile = rs.getString("MOBILE");
            String email = rs.getString("EMAIL");
            String department = rs.getString("DEPARTMENT");

            System.out.printf("%-12d | %-10s | %-10s | %-20s | %-10s\n", empId, name, mobile, email, department);
        }
	}
	
	
	public void printFirstNUsersAsc() throws SQLException {
		System.out.print("Enter the number of employees to fetch: ");
        int n = Integer.parseInt(sc.nextLine());
        ResultSet rs = jdbcTask.printFirstNEmployeesAsc(n);
        
        System.out.println("EMPLOYEE_ID | NAME       | MOBILE      | EMAIL               | DEPARTMENT");
        System.out.println("-----------------------------------------------------------------------");
        while (rs.next()) {
            int empId = rs.getInt("EMPLOYEE_ID");
            String name = rs.getString("NAME");
            String mobile = rs.getString("MOBILE");
            String email = rs.getString("EMAIL");
            String department = rs.getString("DEPARTMENT");

            System.out.printf("%-12d | %-10s | %-10s | %-20s | %-10s\n", empId, name, mobile, email, department);
        }
	}
	
	public void deleteEmployeeById() throws SQLException {
		System.out.print("Enter Employee ID to delete: ");
        int empIdToDelete = Integer.parseInt(sc.nextLine());
        

        int rowsAffected = jdbcTask.deleteEmployeeById(empIdToDelete);
        if (rowsAffected > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found with ID: " + empIdToDelete);
        }
        
        
        printFirstNUsers();
    }

}
