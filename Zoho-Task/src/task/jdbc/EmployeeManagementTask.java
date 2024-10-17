//$Id$
package task.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementTask {
  private static Connection connection = DBConfig.getConnection();

  public void addEmployee(Employee employee) {
      String query = "INSERT INTO Employee (EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?, ?)";

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

  public Employee getEmployeeByName(String name) {
      String query = "SELECT * FROM Employee WHERE NAME = ?";
      Employee employee = new Employee();

      try (PreparedStatement stmt = connection.prepareStatement(query)) {
          stmt.setString(1, name);
          ResultSet rs = stmt.executeQuery();

          if (rs.next()) {
              employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
              employee.setName(rs.getString("NAME"));
              employee.setMobile(rs.getString("MOBILE"));
              employee.setEmail(rs.getString("EMAIL"));
              employee.setDepartment(rs.getString("DEPARTMENT"));
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }

      return employee;
  }

  public List<Employee> getFirstNEmployees(int n) {
      List<Employee> employees = new ArrayList<>();
      String query = "SELECT * FROM Employee LIMIT ?";

      try (PreparedStatement stmt = connection.prepareStatement(query)) {
          stmt.setInt(1, n);
          ResultSet rs = stmt.executeQuery();

          while (rs.next()) {
              Employee employee = new Employee();
              employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
              employee.setName(rs.getString("NAME"));
              employee.setMobile(rs.getString("MOBILE"));
              employee.setEmail(rs.getString("EMAIL"));
              employee.setDepartment(rs.getString("DEPARTMENT"));
              employees.add(employee);
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return employees;
  }

  public List<Employee> getEmployeesSortedByName(int n) {
      List<Employee> employees = new ArrayList<>();
      String query = "SELECT * FROM Employee ORDER BY NAME ASC LIMIT ?";

      try (PreparedStatement stmt = connection.prepareStatement(query)) {
          stmt.setInt(1, n);
          ResultSet rs = stmt.executeQuery();

          while (rs.next()) {
              Employee employee = new Employee(); 
              employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
              employee.setName(rs.getString("NAME"));
              employee.setMobile(rs.getString("MOBILE"));
              employee.setEmail(rs.getString("EMAIL"));
              employee.setDepartment(rs.getString("DEPARTMENT"));
              employees.add(employee);
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return employees;
  }
}
