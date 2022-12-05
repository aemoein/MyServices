package main.Data;

import java.util.ArrayList;

import main.Payment.Wallet;
import main.Transaction.ITransaction;
import main.Transaction.PaymentTransaction;
import main.Transaction.Refund;
import main.User.User;

public class Data {
	private static Data Instance = null;
	
	User user = new User("Ahmed","Elsayed","aemoein@gmail.com","aemoein","1234","01008956099",'m',false);
	private ArrayList<User> users;
	private ArrayList <ITransaction> transactions;
	private ArrayList <Wallet> wallets;
	private ArrayList <Refund> refundRequest;
	private ArrayList <PaymentTransaction> PayTransactions;
	private ArrayList <String> DiscountedServices;
	private ArrayList <String> DiscountedUsers;
	
	private Data() 
	{
		users = new ArrayList<User>();
		transactions = new ArrayList<ITransaction>();
		wallets =  new ArrayList<Wallet>();
		refundRequest = new ArrayList<Refund>();
		PayTransactions = new ArrayList<PaymentTransaction>();
		DiscountedServices = new ArrayList <String>();
		DiscountedUsers = new ArrayList <String>();
		users.add(user);
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

	public ArrayList<PaymentTransaction> getPayTransactions() {
		return PayTransactions;
	}

	public void setPayTransactions(ArrayList<PaymentTransaction> payTransactions) {
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
