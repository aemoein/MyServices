package main;

import java.util.Scanner;

import main.User.LoginForm;
import main.User.SignupForm;

public class SystemEntry
{
	Scanner scanner = new Scanner(System.in);
	public void SystemStart()
	{
		SignupForm signupForm = new SignupForm();
		LoginForm loginForm = new LoginForm();
		int c;
		
		System.out.println("MyServies");
		System.out.println("Choose An Option");
		System.out.println("1- Login");
		System.out.println("2- Sign Up");
		System.out.println("3- Exit");
		System.out.print("Choice: ");
		c = scanner.nextInt();
		
		switch (c) 
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
				throw new IllegalArgumentException("Unexpected value: " + c);
		}
	}
}
