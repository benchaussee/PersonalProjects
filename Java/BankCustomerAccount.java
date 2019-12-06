package Bank;

import java.text.NumberFormat;

public class BankCustomerAccount {
	
 	// customer instance variables
 	private String customerFirstName, customerLastName;
 	private int accountNumber; 
 	private double balance;
 	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
 	
 	public BankCustomerAccount(String first, String last, int num, double bal) {
 		customerFirstName = first;
 		customerLastName = last;
 		accountNumber = num;
 		balance = bal;
 	}
 	
 	//methods
 	public void deposit(double amount) {
 		balance = balance + amount;
 	}
 	
 	public void withdraw(double amount) {
 		balance = balance - amount;
 	}
 	
 	public int getAccountNumber() {
 		return accountNumber;
 	}
 	
 	public String toString() {
 		return "Customer- Name: " + customerFirstName + " " + customerLastName +
 				" | Account number: " + accountNumber + " | Balance: " + currencyFormatter.format(balance) + "\n";
 	}
 	
}
