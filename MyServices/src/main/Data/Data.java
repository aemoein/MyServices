package main.Data;

import java.util.ArrayList;

import main.Payment.Wallet;
import main.Transaction.ITransaction;
import main.Transaction.Refund;
import main.User.User;

public class Data {
	private static Data Instance = null;
	
	User user = new User("Ahmed","Elsayed","aemoein@gmail.com","aemoein","1234","01008956099",'m',false);
	User admin = new User("Ahmed","Elsayed","admin@myservice","admin","12345","01008956099",'m',true);
	private ArrayList<User> users;
	private ArrayList <ITransaction> transactions;
	private ArrayList <Wallet> wallets;
	private ArrayList <Refund> refundRequest;
	private ArrayList <ITransaction> PayTransactions;
	private ArrayList <String> DiscountedServices;
	private ArrayList <String> DiscountedUsers;
	Wallet wallet = new Wallet(user.getUserID(), 0);
	
	private Data() 
	{
		users = new ArrayList<User>();
		transactions = new ArrayList<ITransaction>();
		wallets =  new ArrayList<Wallet>();
		refundRequest = new ArrayList<Refund>();
		PayTransactions = new ArrayList<ITransaction>();
		DiscountedServices = new ArrayList <String>();
		DiscountedUsers = new ArrayList <String>();
		users.add(user);
		users.add(admin);
		wallets.add(wallet);
	}
	
	public ArrayList<String> getDiscountedUsers() {
		return DiscountedUsers;
	}

	public void setDiscountedUsers(ArrayList<String> discountedUsers) {
		DiscountedUsers = discountedUsers;
	}

	public ArrayList<String> getDiscountedServices() {
		return DiscountedServices;
	}

	public void setDiscountedServices(ArrayList<String> discountedServices) {
		DiscountedServices = discountedServices;
	}

	public ArrayList<ITransaction> getPayTransactions() {
		return PayTransactions;
	}

	public void setPayTransactions(ArrayList<ITransaction> payTransactions) {
		PayTransactions = payTransactions;
	}

	public static Data getInstance()
	{
		if(Instance == null)
		{
			Instance = new Data();
		}
		
		return Instance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<ITransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<ITransaction> transactions) {
		this.transactions = transactions;
	}

	public ArrayList<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(ArrayList<Wallet> wallets) {
		this.wallets = wallets;
	}

	public ArrayList<Refund> getRefundRequest() {
		return refundRequest;
	}

	public void setRefundRequest(ArrayList<Refund> refundRequest) {
		this.refundRequest = refundRequest;
	}
}
