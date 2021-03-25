package com.app.Bankdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Bank.dbutil.PostgresConnection;
import com.app.Bank.model.Customer;
import com.app.Bank.model.Transaction;
import com.app.Bankdao.EmployeeDAO;


public class EmployeeDAOImpl implements EmployeeDAO{
	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	@Override
	public Customer approveApplication(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer declineApplication(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	public List<Transaction> seeCustomerTransactions(int id) {
		List<Transaction> transactionList =new ArrayList<>();
		Transaction transaction = null;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql ="select newbalance,customerid, type from \"Banking_Schema\".transaction where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				transaction = new Transaction();
				transaction.setNewbalance(resultSet.getInt("newbalance"));
				transaction.setCustomerid(resultSet.getInt("customerid"));
				transaction.setType(resultSet.getString("type"));
				transactionList.add(transaction);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return transactionList;
				
	}

	@Override
	public int employeeIdFromLogin(String user, String pass) {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()){ 
			String sql = "select employeeid from \"Banking_Schema\".employee Where username = ? And password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				log.info("Welcome!...........");
				
				int r = rs.getInt(1);
				connection.close();
				return r;
			}
			while(rs.next()== false) {
				log.info("This username and password combination does not exist in our system.");
				log.info("Please try again");
				return c;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.trace(e);
		}
		
				
		return c;
	}

		@Override
	public int seePendingAppications() {
		// TODO Auto-generated method stub
		return 0;
	}

}
