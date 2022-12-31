package com.MyServices.Main.Data;

import java.util.ArrayList;

import com.MyServices.Main.Payment.Wallet;
import com.MyServices.Main.Transaction.ITransaction;
import com.MyServices.Main.Transaction.Refund;
import com.MyServices.Main.User.User;

public class Data 
{
	private static Data Instance = null;
	
	User admin = new User("Ahmed","Elsayed","admin@myservice.com","admin","12345","01008956099",'m',true);
	
	User user = new User("Ahmed","Elsayed","aemoein@gmail.com","aemoein","1234","01008956099",'m',false);
	Wallet wallet = new Wallet(user.getUserID(), 0);
	
	User user2 = new User("Ahmed","Sami","A.sami@gmail.com","A_Sami","1234","01091497761",'m',false);
	Wallet wallet2 = new Wallet(user2.getUserID(), 0);
	
	User user3 = new User("Abdulrahman","Emad","abdo@gmail.com","theonlyabdo","1234","01018441349",'m',false);
	Wallet wallet3 = new Wallet(user3.getUserID(), 0);
	
	User user4 = new User("Abdullah","Elsayed","absa@gmail.com","abdo123","1234","0563110647",'m',false);
	Wallet wallet4 = new Wallet(user3.getUserID(), 0);
	
	private ArrayList<User> users;
	private ArrayList <ITransaction> transactions;
	private ArrayList <Wallet> wallets;
	private ArrayList <Refund> refundRequest;
	private ArrayList <ITransaction> PayTransactions;
	private ArrayList <String> DiscountedServices;
	private ArrayList <String> DiscountedUsers;
	
	
	
	private Data() 
	{
		users = new ArrayList<User>();
		transactions = new ArrayList<ITransaction>();
		wallets =  new ArrayList<Wallet>();
		refundRequest = new ArrayList<Refund>();
		PayTransactions = new ArrayList<ITransaction>();
		DiscountedServices = new ArrayList <String>();
		DiscountedUsers = new ArrayList <String>();
		users.add(admin);
		users.add(user);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		wallets.add(wallet);
		wallets.add(wallet2);
		wallets.add(wallet3);
		wallets.add(wallet4);
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
