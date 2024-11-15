package com.banking.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.banking.config.DBConfig;
import com.banking.config.QueryBuilder;
import com.banking.databaseOperations.DBService;
import com.banking.entity.Customer;
import com.banking.entity.LoginActivity;

public class AuthService {
	
	private QueryBuilder queryBuilder;
	private DBService dbService;

	
	public AuthService() {
		queryBuilder = new QueryBuilder();
		dbService = new DBService("/home/raksh-pt7616/Downloads/Zoho/Zoho-Training-main/Project/src/mapping.yaml");
	}
	
	public Optional<Customer> getUserByEmailOrUsername(String email) {

	    String query = queryBuilder
	            .select("*")
	            .table("Customer")
	            .where("emailId", "=", email)
	            .or()
	            .where("username", "=", email)
	            .build();
	    
	    System.out.println(query);
	    
	    // Execute the query and retrieve results
	    List<Customer> customers = dbService.executeQuery(query, Customer.class);
	    
	    // Return the first customer if available, wrapped in Optional
	    return customers.isEmpty() ? Optional.empty() : Optional.of(customers.get(0));
	}
	
	
	public void makeUserActive(String email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userStatus", "active");
		String query = queryBuilder.table("Customer").update(map).where("emailId", " = ", email).or().where("username", " = ", email).build();
		System.out.println(query);
	}
	
	
	public void makeUserInActive(String email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userStatus", "active");
		String query = queryBuilder.table("Customer").update(map).where("emailId", " = ", email).or().where("username", " = ", email).build();
		System.out.println(query);
	}
	
	
	
	public void addLoginActivity() {
		
	}
	
	public Long findCustomerId(String username) {
	    // Generate the query using queryBuilder
	    String query = queryBuilder
	    		.table("Customer")
	        .select("customerId")
	        
	        .where("emailId", " = ", username)
	        .or()
	        .where("username", " = ", username)
	        .build();
	    
	    System.out.println(query);
	    
	    // Initialize the customerId variable
	    Long customerId = null;

	    try (Connection connection = DBConfig.getConnection(); // Ensure you have a method to get a DB connection
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Execute the query
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // If a result is found, set the customerId from the result set
	        if (resultSet.next()) {
	            customerId = resultSet.getLong("customer_id");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Optionally handle or rethrow the exception based on your application requirements
	    }

	    // Return the found customerId or null if not found
	    return customerId;
	}
	
	
	public int addLoginActivity(Long customerId) throws SQLException {
		LoginActivity loginActivity = new LoginActivity();
		loginActivity.setUserId(customerId);
		loginActivity.setLoginTimestamp(Instant.now().toEpochMilli());
		dbService.insert(loginActivity);
		
		String query = "SELECT login_id FROM login_activity WHERE user_id = ? AND login_timestamp = ? ORDER BY login_timestamp DESC LIMIT 1";
	    try (Connection connection = DBConfig.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	        preparedStatement.setLong(1, loginActivity.getUserId());
	        preparedStatement.setLong(2, loginActivity.getLoginTimestamp());
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getInt("login_id");
	            } else {
	                throw new SQLException("Failed to retrieve login_activity ID after insertion.");
	            }
	        }
	    }
	}
	
	public void addLogoutActivity(int  loginId) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("logoutTimestamp", String.valueOf(Instant.now().toEpochMilli()));
		String query = queryBuilder.table("LoginActivity").update(map).
				where("loginId", " = ", String.valueOf(loginId)).
				build();
		
		System.out.println(query);
		
		
		try (Connection connection = DBConfig.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		        
		        
		        
		        try {
		        	preparedStatement.executeUpdate();
		        }
		        finally {
					preparedStatement.close();
				}
		    }
		
	}
	
	
	public void registerCustomer(Customer customer) throws SQLException {
		dbService.insert(customer);
		
	}
	
	
	
	
	public static void main(String[] args) throws SQLException {
		AuthService authService = new AuthService();
//		authService.GetUserByEmailOrUsername("rp@mail.com");
//		authService.addLoginActivity(10005L);
		Optional<Customer> c = authService.getUserByEmailOrUsername("john_doe");
		System.out.println(c);
//		System.out.println(authService.addLoginActivity(10005L));
	}

}
