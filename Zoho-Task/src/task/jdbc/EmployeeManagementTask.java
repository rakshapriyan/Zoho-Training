//$Id$
package task.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementTask {
    private static Connection connection = DBConfig.getConnection();

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employee (employee_id, name, mobile, email, department) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employee.getEmployeeId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getMobile());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getDepartment());

            stmt.executeUpdate();
            System.out.println("Employee added successfully: " + employee);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployeeByName(String name) {
        String query = "SELECT * FROM employee WHERE name = ?";
        List<Employee> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
             
            stmt.setString(1, name);

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setMobile(rs.getString("mobile"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartment(rs.getString("department"));
                list.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Employee> getFirstNEmployees(int n) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee LIMIT ?";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
             
            stmt.setInt(1, n);

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setMobile(rs.getString("mobile"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartment(rs.getString("department"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> getEmployeesSortedByName(int n) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee ORDER BY name ASC LIMIT ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) 
        {
             
            stmt.setInt(1, n);
            try(ResultSet rs = stmt.executeQuery()){
	            while (rs.next()) {
	                Employee employee = new Employee();
	                employee.setEmployeeId(rs.getInt("employee_id"));
	                employee.setName(rs.getString("name"));
	                employee.setMobile(rs.getString("mobile"));
	                employee.setEmail(rs.getString("email"));
	                employee.setDepartment(rs.getString("department"));
	                employees.add(employee);
	            }
	        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
