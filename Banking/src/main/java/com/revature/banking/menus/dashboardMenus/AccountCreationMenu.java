package com.revature.banking.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking.menus.Menu;
import com.revature.banking.models.Account;
import com.revature.banking.services.AccountService;
import com.revature.banking.util.MenuRouter;

public class AccountCreationMenu extends Menu {

	private final AccountService accountService;
	
	public AccountCreationMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("AccountCreation", "/create-account", consoleReader, router);
		this.accountService = accountService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		System.out.println("Account Creator\n" + "Fill out the attributes below");
		
		System.out.println("1 - AccountID");
		String accountId = consoleReader.readLine();

		System.out.println("2 - Savings or Checking");
		String accountType = consoleReader.readLine();
		
		System.out.println("3 - Account name");
		String accountName = consoleReader.readLine();
		
		System.out.println("3 - Account Owner");
		String accountOwner = consoleReader.readLine();
		
		double balance = 0;
		String userId = "000"; //-- get user id
		Account newAccount = new Account(accountId, accountType, accountName, accountOwner, balance, userId);
		
		accountService.createAccount(newAccount);
	}

}
