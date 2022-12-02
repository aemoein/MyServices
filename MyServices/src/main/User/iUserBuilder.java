package main.User;

public interface iUserBuilder {
	public void createUser();
	public void setUserName(String UserName);
	public void setFirstName(String FirstName);
	public void setLastName(String LastName);
	public void setGender(char gender);
	public void setEmail(String Email);
	public void setPassword(String password);
	public void setPhoneNumber(String PhoneNumber);
	public void setAccess();
	public User getUser();
}
