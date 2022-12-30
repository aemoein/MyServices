package com.MyServices.Main.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Data.DataControl;

@RestController
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
	
	@PostMapping ("/User/Build")
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
	
	@PostMapping ("/User/Register")
	public void RegisterUser(User User) 
	{
		dataControl.RegisterUser(User);
	}
	
	// These functions will be used in the log-in form
	@GetMapping ("/User/Check/{username}/{password}")
	public boolean checkUserLoggedIN(@PathVariable("username") String UserName,@PathVariable("password") String Password) 
	{
		return dataControl.checkUserLoggedIN(UserName, Password);
	}
	
	@GetMapping ("/User/CheckAdmin/{username}/{password}")
	public boolean checkAdmin(@PathVariable("username") String UserName, @PathVariable("password") String Password) 
	{
			if(CurrentUser.currentUser.getAccess() == true) 
			{
				return true;
			}
		return false;
	}
	
}
