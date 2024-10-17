package task.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTask {
    private static Connection connection = DBConfig.getConnection();

    public void createTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS employee ("
                + "employee_id INT NOT NULL AUTO_INCREMENT, "
                + "name VARCHAR(100) NOT NULL, "
                + "mobile VARCHAR(10) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "department VARCHAR(50) NOT NULL, "
                + "PRIMARY KEY (employee_id))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void createDependentTable() throws SQLException {
        String createDependentTable = "CREATE TABLE IF NOT EXISTS employee_dependents ("
                + "dependent_id INT NOT NULL AUTO_INCREMENT, "
                + "employee_id INT, "
                + "name VARCHAR(100) NOT NULL, "
                + "age INT NOT NULL, "
                + "relationship VARCHAR(50) NOT NULL, "
                + "PRIMARY KEY (dependent_id), "
                + "FOREIGN KEY (employee_id) REFERENCES employee(employee_id))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createDependentTable);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insertEmployee(String name, String mobile, String email, String department) throws SQLException {
        String sql = "INSERT INTO employee (name, mobile, email, department) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, mobile);
            pstmt.setString(3, email);
            pstmt.setString(4, department);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Map<String, Object>> getEmployeeByName(String name) throws SQLException {
    	String sql = "SELECT employee_id, name, mobile, email, department FROM employee WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Map<String, Object>> employeeList = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> employee = new HashMap<>();
                    employee.put("employee_id", rs.getInt("employee_id"));
                    employee.put("name", rs.getString("name"));
                    employee.put("mobile", rs.getString("mobile"));
                    employee.put("email", rs.getString("email"));
                    employee.put("department", rs.getString("department"));
                    employeeList.add(employee);
                }
                return employeeList;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public int updateEmployeeDetails(int empId, String mobile, String email, String department) throws SQLException {
        String sql = "UPDATE employee SET mobile = ?, email = ?, department = ? WHERE employee_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, mobile);
            pstmt.setString(2, email);
            pstmt.setString(3, department);
            pstmt.setInt(4, empId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Map<String, Object>> printFirstNEmployees(int n) throws SQLException {
        String sql = "SELECT employee_id, name, mobile, email, department FROM employee LIMIT ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, n);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Map<String, Object>> employeeList = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> employee = new HashMap<>();
                    employee.put("employee_id", rs.getInt("employee_id"));
                    employee.put("name", rs.getString("name"));
                    employee.put("mobile", rs.getString("mobile"));
                    employee.put("email", rs.getString("email"));
                    employee.put("department", rs.getString("department"));
                    employeeList.add(employee);
                }
                return employeeList;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Map<String, Object>> printFirstNEmployeesAsc(int n) throws SQLException {
        String sql = "SELECT employee_id, name, mobile, email, department FROM employee ORDER BY name LIMIT ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, n);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Map<String, Object>> employeeList = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> employee = new HashMap<>();
                    employee.put("employee_id", rs.getInt("employee_id"));
                    employee.put("name", rs.getString("name"));
                    employee.put("mobile", rs.getString("mobile"));
                    employee.put("email", rs.getString("email"));
                    employee.put("department", rs.getString("department"));
                    employeeList.add(employee);
                }
                return employeeList;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public int deleteEmployeeById(int empId) throws SQLException {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insertDependent(int empId, String name, int age, String relationship) throws SQLException {
        String sql = "INSERT INTO employee_dependents (employee_id, name, age, relationship) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, relationship);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Map<String, Object>> getDependentsByEmployeeNameOrId(String nameOrId) throws SQLException {
        String sql = "SELECT e.employee_id, e.name, d.dependent_id, d.name AS dependent_name, d.age, d.relationship "
                + "FROM employee e JOIN employee_dependents d ON e.employee_id = d.employee_id "
                + "WHERE e.name = ? OR e.employee_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nameOrId);
            pstmt.setInt(2, Integer.parseInt(nameOrId));
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Map<String, Object>> dependentList = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> dependent = new HashMap<>();
                    dependent.put("employee_id", rs.getInt("employee_id"));
                    dependent.put("name", rs.getString("name"));
                    dependent.put("dependent_id", rs.getInt("dependent_id"));
                    dependent.put("dependent_name", rs.getString("dependent_name"));
                    dependent.put("age", rs.getInt("age"));
                    dependent.put("relationship", rs.getString("relationship"));
                    dependentList.add(dependent);
                }
                return dependentList;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Map<String, Object>> getDependentsForFirstNEmployees(int n) throws SQLException {
        String sql = "SELECT e.employee_id, e.name, d.name AS dependent_name, d.age, d.relationship "
                + "FROM employee e JOIN employee_dependents d ON e.employee_id = d.employee_id "
                + "ORDER BY e.name ASC LIMIT ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, n);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Map<String, Object>> dependentList = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> dependent = new HashMap<>();
                    dependent.put("employee_id", rs.getInt("employee_id"));
                    dependent.put("name", rs.getString("name"));
                    dependent.put("dependent_name", rs.getString("dependent_name"));
                    dependent.put("age", rs.getInt("age"));
                    dependent.put("relationship", rs.getString("relationship"));
                    dependentList.add(dependent);
                }
                return dependentList;	
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
