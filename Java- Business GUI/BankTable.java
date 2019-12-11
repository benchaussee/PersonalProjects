package Bank;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 
public class BankTable extends Application  {
	
	Bank snapBank = new Bank("Snapchat Bank");
	TableView<BankEmployee> table;	

	public static void main(String[] args) {
    	Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
    	//Title of the window
    	stage.setTitle("Snapchat Bank");
    	
    	//Adding Employees
    	snapBank.createNewEmployee("Jake", "Glass", 23483, 77000);
    	snapBank.createNewEmployee("Ben", "Chaussee", 29291, 50000);
    	snapBank.createNewEmployee("Johan", "Mahlum", 54123, 80000);
     	snapBank.createNewEmployee("Tessa", "Shaw", 87435, 100000);   
     	snapBank.createNewEmployee("Brianne", "Chaussee", 31535, 90000);   	
     	snapBank.createNewEmployee("Kristin", "Melby", 98426, 80000);   	
     	snapBank.createNewEmployee("John", "Campanaro", 54123, 99000);   	
     	snapBank.createNewEmployee("Hailey", "Jones", 36542, 777777);   	
     	snapBank.createNewEmployee("Levi", "Jensen", 98521, 100000);   	
     	snapBank.createNewEmployee("John", "Wick", 51100, 9000000);
     	
    	//First Name Column
       	TableColumn<BankEmployee,String> fNameCol = new TableColumn<>("First Name");
    	fNameCol.setMinWidth(200);
    	fNameCol.setCellValueFactory(new PropertyValueFactory<>("empFirstName"));
    	
    	//Last Name Column
       	TableColumn<BankEmployee,String> lNameCol = new TableColumn<>("Last Name");
    	lNameCol.setMinWidth(200);
    	lNameCol.setCellValueFactory(new PropertyValueFactory<>("empLastName"));   	
     	//Employee Number
       	TableColumn<BankEmployee,Integer> empNumCol = new TableColumn<>("Employee Number");
    	empNumCol.setMinWidth(200);
    	empNumCol.setCellValueFactory(new PropertyValueFactory<>("empNumber"));   
     	//Salary
       	TableColumn<BankEmployee,Double> salaryCol = new TableColumn<>("Salary");
    	salaryCol.setMinWidth(200);
    	salaryCol.setCellValueFactory(new PropertyValueFactory<>("empSalary"));   	   		
    	
    	
    	//Creating the table itself
    	table = new TableView<>();
    	table.setItems(BankEmployee.getEmployeeObservableList());
    	
    	table.getColumns().addAll(fNameCol,lNameCol,empNumCol,salaryCol);
    	
    	VBox vbox = new VBox();
    	vbox.getChildren().addAll(table);
    	
    	Scene scene = new Scene(vbox);
    	stage.setScene(scene);
    	        
        stage.show();

    }
    
    
}
