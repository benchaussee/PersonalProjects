package Bank;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Bank {
	
	// bank instance variables
 	private String bankName;
 	private ArrayList<BankEmployee> listOfAllEmployees = new ArrayList<BankEmployee>();
 	private ArrayList<BankCustomerAccount> listOfAllCustomers = new ArrayList<BankCustomerAccount>();
 	
 	public Bank(String name) {
 		bankName = name;
 	}

 	////////////////////////////////////////////////////////////////////////////////////////////////
 	//              EMPLOYEE METHODS           ///////////////////////////////////////////////////// 
 	////////////////////////////////////////////////////////////////////////////////////////////////
 	public void createNewEmployee(String first, String last, int employeeNum, int sal) {
 		BankEmployee newEmployee = new BankEmployee(first, last, employeeNum, sal);
 		listOfAllEmployees.add(newEmployee);
 	}
 	
 	public String returnAllEmployeeInfo() {
 		return listOfAllEmployees.toString();
 	}
 	
 	public void removeEmployee(int employeeNumber) {
 		int initialNumberOfEmployees = listOfAllEmployees.size();
 		for (BankEmployee oneEmployee : listOfAllEmployees) {			
 			if (oneEmployee.getEmpNumber() == employeeNumber) {
 				System.out.println(oneEmployee.getEmpFirstName() + " " + oneEmployee.getEmpLastName()+ " has been removed.");
 				listOfAllEmployees.remove(oneEmployee);				
 				break;
 			}		
 		}
 		int finalNumberOfEmployees = listOfAllEmployees.size();	
 		
 		if (initialNumberOfEmployees == finalNumberOfEmployees) {
 			System.out.println("Employee number not found.");
 		}
 		System.out.println();
 	}
 	
 	////////////////////////////////////////////////////////////////////////////////////////////////
 	//              CUSTOMER METHODS           ///////////////////////////////////////////////////// 
 	////////////////////////////////////////////////////////////////////////////////////////////////
 	public void createCustomerAccount(String first, String last, int num, double bal) {
 		BankCustomerAccount oneCustomer = new BankCustomerAccount(first, last, num, bal);
 		listOfAllCustomers.add(oneCustomer);
 	}
 	
  	public void displayAllCustomerInfo() {
 		for (BankCustomerAccount oneCustomer : listOfAllCustomers) {
 			System.out.println(oneCustomer.toString());
 		}
 		System.out.println();
 	}	

 	public void deposit(int customerAcctNum, double amount) {
 		for (BankCustomerAccount someAccount : listOfAllCustomers) {
 			if (someAccount.getAccountNumber() == customerAcctNum) {
 				someAccount.deposit(amount);
 			}
 		}
 	}
 	
 	public void withdraw(int customerAcctNum, double amount) {
 		for (BankCustomerAccount someAccount : listOfAllCustomers) {
 			if (someAccount.getAccountNumber() == customerAcctNum) {
 				someAccount.withdraw(amount);
 			}
 		}
 	}
  	////////////////////////////////////////////////////////////////////////////////////////////////
 	//              Bank toString           ///////////////////////////////////////////////////// 
 	////////////////////////////////////////////////////////////////////////////////////////////////
	
 	@Override
	public String toString() {
		return "Bank Name: " + bankName + " | Number of employees: " + listOfAllEmployees.size() + "\n";
	}
}
