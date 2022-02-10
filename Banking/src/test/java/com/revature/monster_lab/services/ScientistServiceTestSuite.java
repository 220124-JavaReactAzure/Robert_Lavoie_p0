package com.revature.monster_lab.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.banking.daos.UserDAO;
import com.revature.banking.exceptions.InvalidRequestException;
import com.revature.banking.exceptions.ResourcePersistenceException;
import com.revature.banking.models.User;
import com.revature.banking.services.UserService;


public class ScientistServiceTestSuite {
	
	UserService sut;
	UserDAO mockScientistDAO;
	
	@Before
	public void testPrep() {
		mockScientistDAO = mock(UserDAO.class);
		sut = new UserService(mockScientistDAO);
	}
	
	@Test
	public void test_isScientistValid_returnsTrue_givenValidUser() {
		
		// Arrange
		User validScientist = new User("valid","valid","valid","valid","valid");
		
		// Act
		boolean actualResult = sut.isUserValid(validUser);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isScientistValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		User invalidScientist1 = new User("","valid","valid","valid","valid", "valid");
		User invalidScientist2 = new User(null,"valid","valid","valid","valid");
		User invalidScientist3 = new User("         ","valid","valid","valid","valid");
		
		
		//Act
		boolean actualResult1 = sut.isUserValid(invalidScientist1);
		boolean actualResult2 = sut.isScientistValid(invalidScientist2);
		boolean actualResult3 = sut.isScientistValid(invalidScientist3);
		
		//Assert - everything you assert must pass the condition
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		Assert.assertFalse(actualResult3);
		
	}
	
	//TODO: Figure out implementation. CHARLES YOU DINGLEBERRY MOCK IT!!!!!!!
	@Test
	public void test_registerScientist_returnsTrue_givenValidScientist() {
		// Arrange
		User validScientist = new User("valid","valid","valid","valid","valid");
		when(mockScientistDAO.findByUsername(validScientist.getUsername())).thenReturn(null);
		when(mockScientistDAO.findByEmail(validScientist.getEmail())).thenReturn(null);
		when(mockScientistDAO.create(validScientist)).thenReturn(validScientist);
		
		// Act
		User actualResult = sut.registerNewScientist(validScientist);
		
		// Assert
		Assert.assertNotNull(actualResult);
		verify(mockScientistDAO, times(1)).create(validScientist);
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerScientist_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewScientist(null);
	}
	
	@Test(expected = ResourcePersistenceException.class)
	public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenUsername() {
		
		// Arrange
		User usernameTakenScientist = new User("valid","valid","valid","valid","valid");
		when(mockScientistDAO.findByUsername(usernameTakenScientist.getUsername())).thenReturn(usernameTakenScientist);
		when(mockScientistDAO.findByEmail(usernameTakenScientist.getEmail())).thenReturn(null);
		when(mockScientistDAO.create(usernameTakenScientist)).thenReturn(usernameTakenScientist);
		
		// Act
		try {
			sut.registerNewScientist(usernameTakenScientist);
		} finally {
			// Assert
			verify(mockScientistDAO, times(0)).create(usernameTakenScientist);
		}
	}
		
		@Test(expected = ResourcePersistenceException.class)
		public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenEmail() {
			
			// Arrange
			User emailTakenScientist = new User("valid","valid","valid","valid","valid");
			when(mockScientistDAO.findByUsername(emailTakenScientist.getUsername())).thenReturn(null);
			when(mockScientistDAO.findByEmail(emailTakenScientist.getEmail())).thenReturn(emailTakenScientist);
			when(mockScientistDAO.create(emailTakenScientist)).thenReturn(emailTakenScientist);
			
			// Act
			try {
				sut.registerNewScientist(emailTakenScientist);
			} finally {
				// Assert
				verify(mockScientistDAO, times(0)).create(emailTakenScientist);
			}
		
		
	}
}
