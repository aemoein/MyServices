package main;

import main.User.LoginForm;
import main.User.SignupForm;

public class MainSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuInterface menuInterface = new MenuInterface();
		SignupForm signupForm = new SignupForm();
		LoginForm loginForm = new LoginForm();
		
		//loginForm.loginUser();
		signupForm.SignUpUser();
		menuInterface.menuForm();
	}

}
