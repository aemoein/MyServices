package main.User;

import java.util.Scanner;

public class LoginForm {
	private String userName,password; 
	
	public LoginForm() {};
	
	//setters
	public void setUserName(String UserName){this.userName = userName;};
	public void setPassword(String password){this.password = password;};
	
	//getters
	public String getUserName() {return userName;}
	public String getPassword() {return password;}
	
	
	public void FillInfo(){
		Scanner myscanner =  new Scanner(System.in);
		
		System.out.println("please enter your username or Email: ");
		String UserName = myscanner.next();
		this.setUserName(UserName);
		
		System.out.println("please enter your password: ");
		String password = myscanner.next();
		this.setPassword(password);
	}
	
	
}
