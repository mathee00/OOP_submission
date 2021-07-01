package model;

import java.io.Serializable;

public class User implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId; 
	private String Name;
	private String Email;
	private String userName;
	private String Password;
	
	public User() {
		
	}
	
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return Name;
	}
	public String getEmail() {
		return Email;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return Password;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
