package task.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTask {
    private static Connection connection = DBConfig.getConnection();
    
    // Task 1: Create Employee table
    public void createTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS Employee ("
                + "EMPLOYEE_ID INT NOT NULL AUTO_INCREMENT, "
                + "NAME VARCHAR(100) NOT NULL, "
                + "MOBILE VARCHAR(10) NOT NULL, "
                + "EMAIL VARCHAR(100) NOT NULL, "
                + "DEPARTMENT VARCHAR(50) NOT NULL, "
                + "PRIMARY KEY (EMPLOYEE_ID))";
        Statement stmt = connection.createStatement();
        stmt.execute(createTable);
    }

    // Task 9: Create dependent table for Employees
    public void createDependentTable() throws SQLException {
        String createDependentTable = "CREATE TABLE IF NOT EXISTS EmployeeDependents ("
                + "DEPENDENT_ID INT NOT NULL AUTO_INCREMENT, "
                + "EMPLOYEE_ID INT, "
                + "NAME VARCHAR(100) NOT NULL, "
                + "AGE INT NOT NULL, "
                + "RELATIONSHIP VARCHAR(50) NOT NULL, "
                + "PRIMARY KEY (DEPENDENT_ID), "
                + "FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID))";
        Statement stmt = connection.createStatement();
        stmt.execute(createDependentTable);
    }

    // Task 2: Insert Employee into table
    public void insertEmployee(String name, String mobile, String email, String department) throws SQLException {
        String sql = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, mobile);
        pstmt.setString(3, email);
        pstmt.setString(4, department);
        pstmt.executeUpdate();
    }

    // Task 3: Get Employee by name
    public ResultSet getEmployeeByName(String name) throws SQLException {
        String sql = "SELECT EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT FROM Employee WHERE NAME = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, name);
        return pstmt.executeQuery();
    }

    // Task 4: Update Employee details
    public int updateEmployeeDetails(int empId, String mobile, String email, String department) throws SQLException {
        String sql = "UPDATE Employee SET MOBILE = ?, EMAIL = ?, DEPARTMENT = ? WHERE EMPLOYEE_ID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mobile);
        pstmt.setString(2, email);
        pstmt.setString(3, department);
        pstmt.setInt(4, empId);
        return pstmt.executeUpdate();
    }

    // Task 5: Get first N employees
    public ResultSet printFirstNEmployees(int n) throws SQLException {
        String sql = "SELECT EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT FROM Employee LIMIT ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, n);
        return pstmt.executeQuery();
    }

    // Task 6: Get first N employees sorted by name
    public ResultSet printFirstNEmployeesAsc(int n) throws SQLException {
        String sql = "SELECT EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT FROM Employee ORDER BY NAME LIMIT ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, n);
        return pstmt.executeQuery();
    }

    // Task 7: Delete employee by ID
    public int deleteEmployeeById(int empId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, empId);
        return pstmt.executeUpdate();
    }

    // Task 10: Insert dependent details for employees
    public void insertDependent(int empId, String name, int age, String relationship) throws SQLException {
        String sql = "INSERT INTO EmployeeDependents (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, empId);
        pstmt.setString(2, name);
        pstmt.setInt(3, age);
        pstmt.setString(4, relationship);
        pstmt.executeUpdate();
    }

    // Task 11: Get dependents by employee name or ID
    public ResultSet getDependentsByEmployeeNameOrId(String nameOrId) throws SQLException {
        String sql = "SELECT e.EMPLOYEE_ID, e.NAME, d.DEPENDENT_ID, d.NAME AS DEPENDENT_NAME, d.AGE, d.RELATIONSHIP "
                + "FROM Employee e JOIN EmployeeDependents d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID "
                + "WHERE e.NAME = ? OR e.EMPLOYEE_ID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, nameOrId);
        pstmt.setInt(2, Integer.parseInt(nameOrId));
        return pstmt.executeQuery();
    }

    // Task 12: Get dependent details for first N employees
    public ResultSet getDependentsForFirstNEmployees(int n) throws SQLException {
        String sql = "SELECT e.EMPLOYEE_ID, e.NAME, d.NAME AS DEPENDENT_NAME, d.AGE, d.RELATIONSHIP "
                + "FROM Employee e JOIN EmployeeDependents d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID "
                + "ORDER BY e.NAME ASC LIMIT ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, n);
        return pstmt.executeQuery();
    }
}
