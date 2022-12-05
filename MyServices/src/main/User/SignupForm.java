package main.User;

import java.util.Scanner;

public class SignupForm 
{
	private String FirstName,LastName,
	UserName,Email,password,
	PhoneNumber;
	private char gender;
	private UserControl UserControl;
	private iUserBuilder user;
	Scanner myscanner =  new Scanner(System.in);
	LoginForm loginForm = new LoginForm();
	
	public SignupForm() {
		UserControl = new UserControl();
		user = new NormalUser();
	}
	
	
		
	public void FillInfo()
	{
		
		System.out.print("please enter the First Name: ");
		String FirstName = myscanner.next();
		this.setFirstName(FirstName);
		
		System.out.print("please enter the Last Name: ");
		String LastName = myscanner.next();
		this.setLastName(LastName);
		
		System.out.print("please enter the Email: ");
		String Email = myscanner.next();
		this.setEmail(Email);;
		
		System.out.print("please enter the User-Name: ");
		String UserName = myscanner.next();
		this.setUserName(UserName);
		
		/*******************************************************************
		* please make sure to check if the username unique in the database *
		*******************************************************************/

		boolean loop = true;
		while(loop) 
		{
			System.out.print("please enter the password: ");
			String Password = myscanner.next();
			this.setpassword(Password);
		
			System.out.print("please re-enter the password: ");
			String Password2 = myscanner.next();
			
			if(password.equals(Password2)) 
			{
				loop = false;
			}
			else {
				System.out.println("password not match..");
			}
			
		}
		
		/*
		 * "uvlkwtv4hpou  hpoeq5yh oh poru euhop" <-this is not number
		 * check if PHONENUMBER contains letters or not..  
		 */
		System.out.print("please enter your phone number: ");
		String PhoneNumber = myscanner.next();
		this.setPhoneNumber(PhoneNumber);
		
		System.out.print("please choose your gender (m:male /f:female): ");
		char gender = myscanner.next().charAt(0);
		this.setgender(gender);
		
		/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		 *  gender must be f or m otherwise fuck em
		 */
		
	}
	
	public SignupForm getinfo() {return this;};
	
	public void SignUpUser() 
	{
		FillInfo();
		UserControl.SetUser(this.user);
		UserControl.ControlInfo(getinfo());
		UserControl.constructUser();
		UserControl.RigersterUser(UserControl.getUser());
		loginForm.loginUser();
	}
	
	
	//setters
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
			
		public char getGender() {
			return this.gender;
		}
		
	
}
