package task.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTask {
	private static Connection connection = DBConfig.getConnection();
	
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
	
	
	public void insertEmployee(int empId, String name, String mobile, String email, String department) throws SQLException {
        String sql = "INSERT INTO Employee (EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setInt(1, empId);
        pstmt.setString(2, name);
        pstmt.setString(3, mobile);
        pstmt.setString(4, email);
        pstmt.setString(5, department);

        pstmt.executeUpdate();
    }
	
	
	
	public ResultSet getEmployeeByName(String name) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT FROM Employee WHERE NAME = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, name);

		return pstmt.executeQuery();

        
	}
	
	
	
	public int updateEmployeeDetails( int empId, String mobile, String email, String department) throws SQLException {
        String sql = "UPDATE Employee SET MOBILE = ?, EMAIL = ?, DEPARTMENT = ? WHERE EMPLOYEE_ID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, mobile);
        pstmt.setString(2, email);
        pstmt.setString(3, department);
        pstmt.setInt(4, empId);

        return pstmt.executeUpdate();
       
    }
	
	
	public ResultSet printFirstNEmployees( int n) throws SQLException {
        String sql = "SELECT EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT FROM Employee LIMIT ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setInt(1, n);

        return pstmt.executeQuery();
	}
	
	
	public ResultSet printFirstNEmployeesAsc( int n) throws SQLException {
        String sql = "SELECT EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT FROM Employee LIMIT ? ORDER BY NAME";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setInt(1, n);

        return pstmt.executeQuery();
	}
	
	
	public int deleteEmployeeById(int empId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, empId);

        // Execute the update
        return pstmt.executeUpdate();
    }

}
