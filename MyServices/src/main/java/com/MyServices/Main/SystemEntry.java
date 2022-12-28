package com.MyServices.Main;

import java.util.Scanner;
import com.MyServices.User.LoginForm;
import com.MyServices.User.SignupForm;

public class SystemEntry
{
	Scanner scanner = new Scanner(System.in);
	public void SystemStart()
	{
		SignupForm signupForm = new SignupForm();
		LoginForm loginForm = new LoginForm();
		
		do {
			System.out.println();
			System.out.println("MyServies");
			System.out.println("Choose An Option");
			System.out.println("1- Login");
			System.out.println("2- Sign Up");
			System.out.println("3- Exit");
			
			switch (Input.inputInt(scanner)) 
			{
				case 1: 
				{
					loginForm.loginUser();
					break;
				}
				
				case 2: 
				{
					signupForm.SignUpUser();
					break;
				}
				
				case 3: 
				{
					System.exit(0);
					break;
				}
				default:
					System.out.println("PLEASE ENTER A VALID OPTION");
					break;
			}
			
		}while(true);
		
	}
	
	
}
