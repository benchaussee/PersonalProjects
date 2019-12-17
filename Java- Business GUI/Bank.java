package Bank;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bank {
	
	// bank instance variables
 	private String bankName;
 	private ArrayList<BankEmployee> listOfAllEmployees = new ArrayList<BankEmployee>();
 	private ArrayList<BankCustomer> listOfAllCustomers = new ArrayList<BankCustomer>();	
 	private static ObservableList<BankEmployee> OListofEmployees = FXCollections.observableArrayList();
 	private static ObservableList<BankCustomer> OListofCustomers = FXCollections.observableArrayList();
 	private BankEmployee newEmployee;

	public Bank(String name) {
		bankName = name;
	}

 ////////////////////////////////////////////////////////////////////////////////////////////////
 //              EMPLOYEE METHODS           ///////////////////////////////////////////////////// 
 ////////////////////////////////////////////////////////////////////////////////////////////////
	public void createNewEmployee(String first, String last, int employeeNum, double sal) {
		// linear search to see if employee number is being used
		for (BankEmployee oneEmployee : listOfAllEmployees) {
			if (oneEmployee.getEmpNumber() == employeeNum) {
				System.out.println("Another Employee has that employee number.");
				return;
			}
		}
		newEmployee = new BankEmployee(first, last, employeeNum, sal);
		listOfAllEmployees.add(newEmployee);
		OListofEmployees.add(newEmployee);
	}

	public void removeEmployee(int employeeNumber) {
		for (BankEmployee someEmployee : listOfAllEmployees) {
			if (someEmployee.getEmpNumber() == employeeNumber) {
				listOfAllEmployees.remove(someEmployee);
				OListofEmployees.remove(someEmployee);
				System.out.println(someEmployee.getEmpFirstName() + " " 
						+ someEmployee.getEmpLastName() + " has been removed.");
				return;
			}
		}
		System.out.println("Employee number not found.");
	}

 	public static void clearEmployeeTable() {
		OListofEmployees.clear();
	}
	
 	public static ObservableList<BankEmployee> getEmployeeObservableList(){
    	return OListofEmployees;
    }
 	
 	public void addDemoEmployees() {
	    	//Adding Employees
    	createNewEmployee("Jake", "Thompson", 23483, 77000);
    	createNewEmployee("Ben", "Chaussee", 29291, 50000);
    	createNewEmployee("Johan", "Jacobs", 54123, 80000);
    	createNewEmployee("Tessa", "Jelly", 87435, 100000);   
    	createNewEmployee("Brianne", "Monk", 31535, 90000);   	
    	createNewEmployee("Kristin", "Monaco", 98426, 80000);   	
    	createNewEmployee("John", "Kramp", 55222, 99000);   	
    	createNewEmployee("Hailey", "Jordan", 36542, 777777);   	
    	createNewEmployee("Levi", "Greenfield", 98521, 100000);   	
    	createNewEmployee("John", "Wick", 51100, 9000000);	
    	createNewEmployee("L mf", "D", 92651, 9000000);	
	}	
 	
 	public void clearEmployeeList() {
 		listOfAllEmployees.clear();
 	}
 ////////////////////////////////////////////////////////////////////////////////////////////////
 //              CUSTOMER METHODS           ///////////////////////////////////////////////////// 
 ////////////////////////////////////////////////////////////////////////////////////////////////
	public void createCustomerAccount(String first, String last, int num, double bal) {
		for (BankCustomer someCustomer : listOfAllCustomers) {
			if (someCustomer.getAccountNumber() == num) {
				System.out.println("Another customer has that account number.");
				return;
			}
		}
		BankCustomer someCustomer = new BankCustomer(first, last, num, bal);
		listOfAllCustomers.add(someCustomer);
 		OListofCustomers.add(someCustomer);
	}

	public void deposit(int customerAcctNum, double amount) {
		for (BankCustomer someAccount : listOfAllCustomers) {
			if (someAccount.getAccountNumber() == customerAcctNum) {
				someAccount.deposit(amount);
			}
		}
	}

	public void withdraw(int customerAcctNum, double amount) {
		for (BankCustomer someAccount : listOfAllCustomers) {
			if (someAccount.getAccountNumber() == customerAcctNum) {
				someAccount.withdraw(amount);
			}
		}
	}	
	
	public void addDemoCustomers() {
    	//Adding Employees
		createCustomerAccount("Ballz", "Whom", 23483, 77000);
		createCustomerAccount("Ben", "Chaussee", 29291, 50000);
		createCustomerAccount("Grey", "Beard", 54123, 80000);
		createCustomerAccount("I", "Galaxis", 87435, 100000);   
		createCustomerAccount("Brianne", "Monk", 31535, 90000);   	
		createCustomerAccount("Darrion", "Harris", 98426, 80000);   	
		createCustomerAccount("Twitch", "Chat", 55177, 99000);   	
	} 	
	
	public static ObservableList<BankCustomer> getCustomerObservableList(){
    	return OListofCustomers;
    }
	public void removeCustomer(int acctNumber) {
		for (BankCustomer someCustomer : listOfAllCustomers) {
			if (someCustomer.getAccountNumber() == acctNumber) {
				listOfAllCustomers.remove(someCustomer);
				OListofCustomers.remove(someCustomer);
				System.out.println(someCustomer.getCustomerFirstName() + " " 
						+ someCustomer.getCustomerLastName() + " has been removed.");
				return;
			}
		}
		System.out.println("Customer not found.");
	}
	public static void clearCustomerTable() {
		OListofCustomers.clear();
	}
 	public void clearCustomerList() {
 		listOfAllCustomers.clear();
 	}

  	////////////////////////////////////////////////////////////////////////////////////////////////
 	//              Bank Methods           ///////////////////////////////////////////////////// 
 	////////////////////////////////////////////////////////////////////////////////////////////////
	public String getBankName() {
		return bankName;
	}
	
	@Override
	public String toString() {
		return "Bank Name: " + bankName + " | Number of employees: " + listOfAllEmployees.size() + "\n";
	}
}

















