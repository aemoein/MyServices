package main.User;

import main.Payment.Wallet;

public class User {
	private String FirstName,LastName,
	UserName,Email,password,
	PhoneNumber;
	private int UserID;
	private char gender;
	private boolean SuperUserAccess;
	
	public User() 
	{
		this.UserID = UserCounter.UserCounter;
		this.FirstName = "";
		this.LastName = "";
		this.UserName = "";
		this.Email = "";
		this.password = "";
		this.PhoneNumber = "";
		this.gender = '-';
		this.SuperUserAccess = false;
		UserCounter.UserCounter++;
	}
	
	public User(String FirstName,String LastName,
		String Email,String userNameAccess,
		String password,String PhoneNumber,
		char gender,boolean SuperUserAcsess) 
	{
		UserID++;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.UserName = userNameAccess;
		this.Email = Email;
		this.password = password;
		this.PhoneNumber = PhoneNumber;
		this.gender = gender;
		this.SuperUserAccess = SuperUserAcsess;
	}
	
	//setters.
	public void setFirstName(String FirstName) {
	this.FirstName = FirstName;
	}
	
	public void setLastName(String LastName) {
	this.LastName = LastName;
	}
	
	public void setUserName(String UserName) {
	this.UserName = UserName;
	}
	
	public void setEmail(String Email) {
	this.Email = Email;
	}
	
	public void setpassword(String password) {
	this.password = password;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
	this.PhoneNumber = PhoneNumber;
	} 
	
	public void setgender(char gender) {
	this.gender = gender;
	}
	
	public void setAccess(boolean SuperUserAccess) {
	this.SuperUserAccess = SuperUserAccess;
	}
	
	
	
	//getters.
	public String getFirstName () {
		return this.FirstName;
	}
	
	public String getLasstName() {
		return this.LastName;
	}
	
	public String getUserName() {
		return this.UserName;
	}
	
	public String getEmail() {
		return this.Email;
	}
	
	public String getpassword() {
		return this.password;
	}
	
	public String getPhoneNumber() {
		return this.PhoneNumber;
	}
	
	public boolean getAccess() {
		return this.SuperUserAccess;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getUserID() {
		return this.UserID;
	}
	
	
	public void display() {
		System.out.println(FirstName+"\n"
							+LastName+"\n"
							+UserName+"\n"
							+password+"\n"
							+PhoneNumber+"\n"
							+gender+"\n"
							+Email+"\n"
							+SuperUserAccess+"\n"
							+UserID+"\n");
	}
	
	
	

}
