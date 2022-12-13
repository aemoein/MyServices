package main.User;

public class CurrentUser 
{
	public static User currentUser;
	
	public void printCurrentUser()
	{
		System.out.println("Name:\t\t " + currentUser.getFirstName() + " " + currentUser.getLasstName());
		System.out.println("Email:\t\t " + currentUser.getEmail());
		System.out.println("Phone Number:\t " + currentUser.getPhoneNumber());
		System.out.println("User Name:\t " + currentUser.getUserName());
		String Gender;
		if(currentUser.getGender() == 'm')
		{
			Gender = "Male";
			System.out.println("Gender:\t\t " + Gender);
		}
		else if (currentUser.getGender() == 'f')
		{
			Gender = "Female";
			System.out.println("Gender:\t\t " + Gender);
		}
			
	}
}
