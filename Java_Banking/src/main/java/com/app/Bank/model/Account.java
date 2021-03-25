package com.app.Bank.model;

import java.util.Date;

public class Account {
	
	private int id;
	private int balance;
	private Date datecreated;
	private int customerid;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int id, int balance, Date datecreated, int customerid) {
		super();
		this.id = id;
		this.balance = balance;
		this.datecreated = datecreated;
		this.customerid = customerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", datecreated=" + datecreated + ", customerid="
				+ customerid + "]";
	}
	
	
	

}
