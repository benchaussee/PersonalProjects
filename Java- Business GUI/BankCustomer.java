package Bank;

import java.text.NumberFormat;


public class BankCustomer {
	
 	// customer instance variables
 	private String customerFirstName, customerLastName;
 	private int accountNumber; 
 	private double balance;
 	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
 	
 	public BankCustomer(String first, String last, int num, double bal) {
 		customerFirstName = first;
 		customerLastName = last;
 		accountNumber = num;
 		balance = bal;
 	}
 	
 	//methods
 	public void deposit(double amount) {
 		balance += amount;
 	}
 	
 	public void withdraw(double amount) {
 		balance -= amount;
 	}
 	
 	public String getCustomerFirstName() {
 		return customerFirstName;
 	}
 	
 	public String getCustomerLastName() {
 		return customerLastName;
 	}
 	
 	public int getAccountNumber() {
 		return accountNumber;
 	}
 	
 	public double getBalance() {
 		return balance;
 	}
 	
 	public String toString() {
 		return "Customer- Name: " + customerFirstName + " " + customerLastName +
 				" | Account number: " + accountNumber + " | Balance: " + currencyFormatter.format(balance) + "\n";
 	}
 	
}
