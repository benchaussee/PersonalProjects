package Bank;

import java.text.NumberFormat;

public class BankEmployee {
	
 	// employee instance variables
 	private String empFirstName, empLastName;
 	private int empNumber;
 	private double empSalary;
 	private static int employeeCount;
 	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
 
 	// constructor
 	public BankEmployee(String first, String last, int eNum, int sal) {
 		empFirstName = first;
 		empLastName = last;
 		empNumber = eNum;
 		empSalary = sal;
 		employeeCount++;
 	}
 	
 	public int getEmpNumber() {
 		return empNumber;
 	}
 	
 	public String getName() {
 		return empFirstName + " " + empLastName;
 	}

	@Override
	public String toString() {
		return "Name: " + empFirstName + " " + empLastName + " | Employee Number "
				+ empNumber + " |  Salary: " + currencyFormatter.format(empSalary) + "\n";
	}
	
	public static int getEmployeeCount() {
		return employeeCount;
	}
	
}
