package com.MyServices.Main.User;

import java.util.Scanner;
import com.MyServices.Main.MenuInterface;
import com.MyServices.Main.SystemEntry;

public class LoginForm 
{
	private String userName,password;
	private UserControl userControl;
	private MenuInterface menuInterface = new MenuInterface();
	private AdminMenuForm adminMenuForm = new AdminMenuForm();
	private SystemEntry systemEntry = new SystemEntry();
	
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
		System.out.println();
		System.out.println("--- Login Form ---");
		System.out.print("please enter your username or Email: ");
		String UserName = myscanner.next();
		this.setUserName(UserName);
		
		System.out.print("please enter your password: ");
		String password = myscanner.next();
		this.setPassword(password);
		System.out.println();
	}
	
	public void loginUser() 
	{

		FillInfo();
		
		if(userControl.checkUserLoggedIN(userName, password)) 
		{
			if(CurrentUser.currentUser.getAccess()) 
			{
				System.out.println();
				adminMenuForm.AdminMenu();
			}
			
			else if (CurrentUser.currentUser.getAccess() == false)
			{
				System.out.println();
				menuInterface.menuForm();
			}
		} 
		
		else 
		{
			systemEntry.SystemStart();
		}
	}
}
