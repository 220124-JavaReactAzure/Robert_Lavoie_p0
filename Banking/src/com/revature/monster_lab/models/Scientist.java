package com.revature.monster_lab.models;

import java.util.Objects;

public class Scientist {
	
	// Attributes/Variables
	private String scientistId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	// Constructor
	public Scientist() {
		super();
	}
	
	public Scientist(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Scientist(String scientistId, String firstName, String lastName, String email, String username,
			String password) {
		super();
		this.scientistId = scientistId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	// Getters & Setters
	public String getScientistId() {
		return scientistId;
	}

	public void setScientistId(String scientistId) {
		this.scientistId = scientistId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Custom Methods
	public String toFileString() {
		StringBuilder buildFileString = new StringBuilder();
		
		buildFileString.append(firstName).append(":")
						.append(lastName).append(":")
						.append(email).append(":")
						.append(username).append(":")
						.append(password);
		return buildFileString.toString();
	}
	
	public void printFromFile(String[] arr) {
		for(String arrV:arr) {
			System.out.println(arrV);
		}
		
	}
	
	// Overrides come last
	@Override
	public String toString() {
		return "Scientist [scientistId=" + scientistId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, scientistId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scientist other = (Scientist) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(scientistId, other.scientistId) && Objects.equals(username, other.username);
	}
	
	
}
