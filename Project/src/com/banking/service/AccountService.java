package com.banking.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.config.Criteria;
import com.banking.config.QueryBuilder;
import com.banking.databaseOperations.DBService;
import com.banking.entity.Account;

public class AccountService {
	
	
	private QueryBuilder queryBuilder;
	private DBService dbService;
	
	public AccountService() {
		queryBuilder = new QueryBuilder();
		dbService = new DBService("/home/raksh-pt7616/Downloads/Zoho/Zoho-Training-main/Project/src/mapping.yaml");
	}
	
	public void addAccount(Account account) throws SQLException {
		dbService.insert(account);
	}
	
	public List<Account> getAccountByCustomer(Long customerId){
		Criteria c = new Criteria();
		c.setColumn("customerId");
		c.setCompareOperator(" = ");
		c.setValue(String.valueOf(customerId));
		List<Criteria> criteria = new ArrayList<Criteria>();
		criteria.add(c);
		List<Account> list = dbService.get(Account.class, criteria);
		return list;
		
	}
	
	
	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		
		System.out.println(accountService.getAccountByCustomer(10005L));
		QueryBuilder queryBuilder = new QueryBuilder();
		
	}

}
