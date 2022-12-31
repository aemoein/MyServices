package com.MyServices.Main.Data;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyServices.Main.Payment.Wallet;
import com.MyServices.Main.User.CurrentUser;
import com.MyServices.Main.User.User;
import com.MyServices.Main.User.UserCounter;

@RestController
public class UserDataControl 
{
	Data data = Data.getInstance();
	
	
	@GetMapping("/Data/Display/User/{id}")
	public User getUser(@PathVariable("id") int UID)
	{
		User temUser;
		Iterator<User> itr = data.getUsers().iterator();
		while (itr.hasNext()) 
		{
			temUser = itr.next();
			if (temUser.getUserID() == UID)
			{
				return temUser;
			}
		}
		return null;
	}
	
	@GetMapping("/Data/Display/AllUsers")
	public void DisplayAllUsers()
	{
		Iterator<User> itr = data.getUsers().iterator();
		while (itr.hasNext()) 
		{
			System.out.println();
			itr.next().display();
			System.out.println();
		}
	}
	
	@GetMapping("/Data/Check/User/SignUp")
	public boolean checkUserSignUP(@RequestBody User User) 
	{
		User tempUser;
		if(UserCounter.UserCounter == 1)
		{
			return true;
		}
		
		else 
		{
			Iterator<User> i = data.getUsers().iterator();
			while (i.hasNext()) 
			{
				 tempUser = i.next();
				if(tempUser.getEmail() == User.getEmail()) {
					System.out.println("Sorry this email is already taken :("+"\n");
					return false;
				}
				
				if(tempUser.getUserName() == User.getUserName()) {
					System.out.println("Sorry this username is already taken :("+"\n");
					return false;	
				}
			}
		}
		return true;
	}
	
	@PostMapping("/Data/Add/Wallet")
	public void createwallet(@RequestBody int UID)
	{
		Wallet wallet = new Wallet(UID, 0);
		data.getWallets().add(wallet);
	}
	
	@PostMapping("/Data/Add/User")
	public void RegisterUser(@RequestBody User User) 
	{
		if(checkUserSignUP(User)) 
		{
			data.getUsers().add(User);
			createwallet(User.getUserID());
		}
	}
	
	@GetMapping("/Data/Check/User/Login/{username}/{password}")
	public boolean checkUserLoggedIN(@PathVariable("username") String UserName, @PathVariable("password") String Password) 
	{
		User tempUser;
		Iterator<User> i = data.getUsers().iterator();
		while (i.hasNext()) 
		{
			tempUser = i.next();
			String CurrentUserName = tempUser.getUserName();
			String CurrPassword = tempUser.getpassword();
			String CurrEmail = tempUser.getEmail();
			
			if(CurrentUserName.equals(UserName) || CurrEmail.equals(UserName))
			{
				if (Password.equals(CurrPassword))
				{
					CurrentUser.currentUser = tempUser; 
					return true;
				}
			}	
		}
		System.out.println("The Username/Email or password is incorrect..");
		return false;
	}
}
