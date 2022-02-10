package com.revature.banking.services;

//import java.io.File;
//import java.io.FileWriter;

import com.revature.banking.daos.UserDAO;
import com.revature.banking.exceptions.AuthenticationException;
import com.revature.banking.exceptions.InvalidRequestException;
import com.revature.banking.exceptions.ResourcePersistenceException;
import com.revature.banking.models.User;
import com.revature.banking.util.collections.List;

public class UserService {

	private final UserDAO userDao;
	private User sessionUser;
	
	public UserService(UserDAO userDAO) {
		this.userDao = userDAO;
		this.sessionUser = null;
	}
	
	public User getSessionUser() {
		return sessionUser;
	}
	
	public User registerNewUser(User newUser) {
		if(!isUserValid(newUser)) {
			throw new InvalidRequestException("Invalid user data provider");
		}

		boolean usernameAvailable = userDao.findByUsername(newUser.getUsername()) == null;
		boolean emailAvailable = userDao.findByEmail(newUser.getEmail()) == null;
		
		if(!usernameAvailable || !emailAvailable) {
			if(!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("The provided username was already taken in the database");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email was already taken in the database");
			} else {
				throw new ResourcePersistenceException("The provided username and email were already taken in the database");
			}
		}
		
		User persistedUser = userDao.create(newUser);
		
		if(persistedUser == null) {
			throw new ResourcePersistenceException("The account could not be persisted");
		}
		
		return persistedUser;
	}
	
	public List<User> getAllUsers(){
		return userDao.findAll();	
	}
	
	//TODO: Implement authentication
	public void authenticateUser(String username, String password) {
		
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		User authenticatedUser = userDao.findByUsernameAndPassword(username, password);
		
		if(authenticatedUser == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		sessionUser = authenticatedUser;
	}

	public boolean isUserValid(User newUser) {
		if(newUser == null) return false;
		if(newUser.getFirstName() == null || newUser.getFirstName().trim().equals("")) return false;
		if(newUser.getLastName() == null || newUser.getLastName().trim().equals("")) return false;
		if(newUser.getEmail() == null || newUser.getEmail().trim().equals("")) return false;
		if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")) return false;
		return newUser.getPassword() != null || !newUser.getPassword().trim().equals("");


	}
	
	public void logout() {
		sessionUser = null;
	}
	
	public boolean isSessionActive() {
		return sessionUser != null;
	}
}
