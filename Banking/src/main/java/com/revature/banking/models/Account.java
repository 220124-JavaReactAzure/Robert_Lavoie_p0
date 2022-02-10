package com.revature.banking.models;

public class Account {
	private String accountId;
	private String accountType;
	private String accountName;
	private String accountOwner;
	private double balance;
	private String userId; 
	// constructors
	public Account() {
		super();
	}

	public Account(String accountId, String accountType, String accountName, String accountOwner, double balance, String userId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountName = accountName;
		this.accountOwner = accountOwner;
		this.balance = balance;
		this.userId = userId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	// getter and setters

	
}
