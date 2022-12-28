package com.MyServices.User;

import com.MyServices.Data.DataControl;

public class UserControl {
	
	DataControl dataControl = new DataControl();
	
	//here we build the user from the sign up form.
	private iUserBuilder user;
	private String FirstName,LastName,
		UserName,Email,password,
		PhoneNumber;
	private char gender;
	
	public User getUser() 
	{
		return user.getUser();
	}
	
	
	//this function sets the user superuser or normal user.  
	public void SetUser(iUserBuilder user) 
	{
		this.user = user;
	}
	
	public void ControlInfo(SignupForm sForm) 
	{
		this.FirstName=sForm.getFirstName();
		this.LastName=sForm.getLasstName();
		this.gender =sForm.getGender();
		this.Email=sForm.getEmail();
		this.password=sForm.getpassword();
		this.PhoneNumber=sForm.getPhoneNumber();
		this.UserName=sForm.getUserName();
	}
	
	public void constructUser() 
	{
		user.createUser();
		user.setAccess();
		user.setEmail(Email);
		user.setFirstName(FirstName);
		user.setLastName(LastName);
		user.setUserName(UserName);
		user.setPassword(password);
		user.setPhoneNumber(PhoneNumber);
		user.setGender(gender);
	}
	
	public void RegisterUser(User User) 
	{
		dataControl.RegisterUser(User);
	}
	
	// These functions will be used in the log-in form
	public boolean checkUserLoggedIN(String UserName,String Password) 
	{
		return dataControl.checkUserLoggedIN(UserName, Password);
	}
	
	public boolean checkAdmin(String UserName,String password) 
	{
			if(CurrentUser.currentUser.getAccess() == true) 
			{
				return true;
			}
			
		return false;
	}
	
}
