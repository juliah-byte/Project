package com.app.Bankdao;

import java.util.List;

import com.app.Bank.model.Customer;
import com.app.Bank.model.Transaction;

public interface EmployeeDAO {
	
	public Customer approveApplication(Customer customer);
	public Customer declineApplication(Customer customer);
	public List<Transaction> seeCustomerTransactions(int id);
	public int employeeIdFromLogin(String user, String pass);
	int seePendingAppications();

}
