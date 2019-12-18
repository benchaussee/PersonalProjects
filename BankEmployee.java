package Bank;

import java.text.NumberFormat;

// How we add one employee at a time
public class BankEmployee{
	
 	// employee instance variables
 	private String empFirstName, empLastName;
 	private int empNumber;
 	private double empSalary;
 	private static int employeeCount;
 	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
 
 	// constructor
 	public BankEmployee() {
 		empFirstName = "ben";
 	}
 	
 	public BankEmployee(String first, String last, int eNum, double sal) {
 		empFirstName = first;
 		empLastName = last;
 		empNumber = eNum;
 		empSalary = sal;
 		employeeCount++;
 	}
	
	//~~~~~~~~~~~~~~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public int getEmpNumber() {
 		return empNumber;
 	}
 	public String getEmpFirstName() {
 		return empFirstName;
 	}
 	public String getEmpLastName() {
 		return empLastName;
 	}
 	public Double getEmpSalary() {
 		return empSalary;
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
