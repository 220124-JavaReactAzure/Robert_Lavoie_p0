package com.revature.banking.menus.startPages;

import java.io.BufferedReader;

import com.revature.banking.exceptions.AuthenticationException;
import com.revature.banking.menus.Menu;
import com.revature.banking.models.User;
import com.revature.banking.services.UserService;
import com.revature.banking.util.MenuRouter;
//import com.revature.banking.util.collections.List;

public class LoginMenu extends Menu {

	private final UserService userService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Login", "/login", consoleReader, router);
		this.userService = userService;
	
	}

	@Override
	public void render() throws Exception {
		 System.out.println("Please enter your credentials for you account.");
	     System.out.print("Username: ");
	     String username = consoleReader.readLine();
	     System.out.print("Password: ");
	     String password = consoleReader.readLine();
	        
	     try {
	    	 userService.authenticateUser(username, password);
	    	 router.transfer("/dashboard");
	        } catch (AuthenticationException e) {
	            System.out.println("Incorrect credentials provided! No matching user account found.");
	        }
	     
	        
	}

}
