package main.User;

public class UserControl {
	
	
/****************************************************************************
****************************************************************************/
	
	//here we build the user from the sign up form.
	private iUserBuilder user;
	private String FirstName,LastName,
		UserName,Email,password,
		PhoneNumber;
	private char gender;
	
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
	
	public User getUser() {
		return user.getUser();
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
/****************************************************************************
****************************************************************************/
}
