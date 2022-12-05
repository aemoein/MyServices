package main.User;

import java.util.Scanner;

import main.MenuInterface;

public class LoginForm {
	private String userName,password;
	private UserControl userControl;
	private MenuInterface menuInterface = new MenuInterface();
	private AdminMenuForm adminMenuForm = new AdminMenuForm();
	
	Scanner myscanner =  new Scanner(System.in);
	
	public LoginForm() 
	{
		userControl = new UserControl();
	};
	
	//setters
	public void setUserName(String userName){this.userName = userName;};
	public void setPassword(String password){this.password = password;};
	
	//getters
	public String getUserName() {return userName;}
	public String getPassword() {return password;}
	
	
	public void FillInfo()
	{
		System.out.print("please enter your username or Email: ");
		String UserName = myscanner.next();
		this.setUserName(UserName);
		
		System.out.print("please enter your password: ");
		String password = myscanner.next();
		this.setPassword(password);
	}
	
	public void loginUser() 
	{
		FillInfo();
		
		if(userControl.checkUserLoggedIN(userName, password)) 
		{
			if(userControl.checkAdmin(userName, password)) 
			{
				System.out.println();
				adminMenuForm.AdminMenu();
			}
			
			else 
			{
				System.out.println();
				menuInterface.menuForm();
			}
		}
	}
}
