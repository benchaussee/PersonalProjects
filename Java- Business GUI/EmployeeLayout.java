package Bank;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeLayout  {
	
	private Scene empScene;
	private TableView<BankEmployee> table;
	Bank copyOfBank;
	
	public EmployeeLayout(Bank someBank) {
		copyOfBank = someBank;	
	}

	public void generateEmployeeTable() {
    	//Clearing tables and re-adding 
    //	Bank.clearEmployeeTable();
	//	copyOfBank.clearEmployeeList();
    	copyOfBank.addDemoEmployees();
     	
    	//First Name Column
       	TableColumn<BankEmployee,String> fNameCol = new TableColumn<>("First Name");
    	fNameCol.setMinWidth(200);
    	fNameCol.setCellValueFactory(new PropertyValueFactory<>("empFirstName"));
    	//Last Name Column
       	TableColumn<BankEmployee,String> lNameCol = new TableColumn<>("Last Name");
    	lNameCol.setMinWidth(200);
    	lNameCol.setCellValueFactory(new PropertyValueFactory<>("empLastName"));   	
     	//Employee Number Column	
       	TableColumn<BankEmployee,Integer> empNumCol = new TableColumn<>("Employee Number");
    	empNumCol.setMinWidth(200);
    	empNumCol.setCellValueFactory(new PropertyValueFactory<>("empNumber"));   
     	//Salary Column
       	TableColumn<BankEmployee,Double> salaryCol = new TableColumn<>("Salary");
    	salaryCol.setMinWidth(200);
    	salaryCol.setCellValueFactory(new PropertyValueFactory<>("empSalary"));   	   		
    	
    	//Creating the table itself
    	table = new TableView<>();
    	table.setItems(Bank.getEmployeeObservableList());
    	table.getColumns().addAll(fNameCol,lNameCol,empNumCol,salaryCol);
	}
	
	public TableView<BankEmployee> getEmployeeTable(){
		return table;
	}
	
}
























