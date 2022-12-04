package main.User;

import java.util.Iterator;

import main.Data.Data;

public class UserControl {
	
	/************************************/
	
	private Data database; 		
	//a DATABASE to control the sign-up. 
	
	/************************************/
	
	
/****************************************************************************
****************************************************************************/
	
	//here we build the user from the sign up form.
	
	private iUserBuilder user;
	private String FirstName,LastName,
		UserName,Email,password,
		PhoneNumber;
	private char gender;
	private User currentUser;
	
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public User getCurrentUser() {return this.currentUser;}
	
	public User getUser() {return user.getUser();}
	
	
	//this function sets the user superuser or normal user.  
	public void SetUser(iUserBuilder user) {
		this.user = user;
	}
	
	public void ControlInfo(SignupForm sForm) {
		this.FirstName=sForm.getFirstName();
		this.LastName=sForm.getLasstName();
		this.gender =sForm.getGender();
		this.Email=sForm.getEmail();
		this.password=sForm.getpassword();
		this.PhoneNumber=sForm.getPhoneNumber();
		this.UserName=sForm.getUserName();
	}
	
	
	
	public void constructUser() {
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
	
	/*********************************************************
	* 	These functions will be used in the sign-up form	 *
	*********************************************************/
	
	public boolean checkuserSignUP(User User) {
		while(!database.getUsers().isEmpty()) {
			Iterator<User> i = database.getUsers().iterator();
			while (i.hasNext()) {
				
				if(i.next().getEmail() == User.getEmail()) {
					System.out.println("Sorry this email is already taken :("+"\n");
					return false;
				}
				
				if(i.next().getUserName() == User.getUserName()) {
					System.out.println("Sorry this username is already taken :("+"\n");
					return false;	
				}
			}
		}
		return true;
		
	}
	
	public void RigersterUser(User User) {
		if(checkuserSignUP(User)) {
			database.getUsers().add(User);
		}
	}
	
	/*********************************************************
	* 	 These functions will be used in the log-in form	 *
	*********************************************************/
	
	public boolean checkUserLoggedIN(String UserName,String Password) {
		
			User tempUser;
			Iterator<User> i = database.getUsers().iterator();
			
			while (i.hasNext()) {
				tempUser = i.next();
				if((tempUser.getEmail() == UserName 
						|| tempUser.getUserName() == UserName)
						&& password == tempUser.getpassword()) {
					
						setCurrentUser(tempUser); 
						return true;
					
				}
			}
		
		System.out.println("The Username/Email or password is incorrect..");
		return false;
	}
	
	public boolean checkAdmin(String UserName,String password) {
		if(checkUserLoggedIN(UserName, password)) {
			if(currentUser.getAccess()==true) {
				return true;
			}
		};
		return false;
	}
	
	
	/*******************************************************
	* this function will be called one time to  		   *
	*******************************************************/
	
/****************************************************************************
****************************************************************************/
}
