package com.revature.banking.services;

import com.revature.banking.daos.AccountDAO;
import com.revature.banking.exceptions.InvalidRequestException;
import com.revature.banking.exceptions.ResourcePersistenceException;
import com.revature.banking.models.Account;
import com.revature.banking.util.collections.List;

public class AccountService {
	
	private final AccountDAO accountDAO;
	private final UserService userService;
	
	public AccountService(AccountDAO accountDAO, UserService userService) {
		this.accountDAO = accountDAO;
		this.userService = userService;
	}
	
	// TODO: Monster Creation implementation
	public void createAccount(Account newAccount) {
		if(!isAccountValid(newAccount)) {
			throw new InvalidRequestException("The account was provided invalid information");
		}
		
		//newAccount.setUserId(userService.getSessionUser());
		Account createdAccount = accountDAO.create(newAccount);
		
		if(createdAccount == null) {
			throw new ResourcePersistenceException("The account could not be persisted");
		}
	}
	
	private boolean isAccountValid(Account newAccount) {
		
		if(newAccount == null) return false;
		if(newAccount.getAccountName() == null || newAccount.getAccountName().trim().equals("")) return false;
		return newAccount.getAccountOwner() != null || newAccount.getAccountOwner().trim().equals("");
	}
	
	public List<Account> findMyAccounts(){
		return null;
	}
	
	public List<Account> findAllAccounts(){
		return null;
	}

}
