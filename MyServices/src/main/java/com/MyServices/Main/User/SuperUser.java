package com.MyServices.Main.User;

import org.springframework.stereotype.Component;

//@Component
public class SuperUser implements iUserBuilder {
	private User user;
	
	public void createUser() {
		this.user = new User();
	}
	
	@Override
	public void setUserName(String UserName) {
		// TODO Auto-generated method stub
		user.setUserName(UserName);
	}

	@Override
	public void setFirstName(String FirstName) {
		// TODO Auto-generated method stub
		user.setFirstName(FirstName);
	}

	@Override
	public void setLastName(String LastName) {
		// TODO Auto-generated method stub
		user.setLastName(LastName);
	}

	@Override
	public void setGender(char gender) {
		// TODO Auto-generated method stub
		user.setgender(gender);
	}

	@Override
	public void setEmail(String Email) {
		// TODO Auto-generated method stub
		user.setEmail(Email);
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		user.setpassword(password);
	}

	@Override
	public void setPhoneNumber(String PhoneNumber) {
		// TODO Auto-generated method stub
		user.setPhoneNumber(PhoneNumber);
	}

	@Override
	public void setAccess() 
	{
		user.setAccess(true);
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
}
