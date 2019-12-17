package Bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EmployeeScene implements EventHandler<ActionEvent>  {
	private AddEmployeeScene addEmpScene;
	private DeleteEmployeeScene delEmpScene;
	private Bank copyOfBank;
	private Button addEmpButton,delEmpButton,backToMainButton;
	private TableView<BankEmployee> table;
	private static int runOnlyOnce = 0;
	
	public EmployeeScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	 
	public void setEmployeeLayoutScene() {
		addEmpButton = new Button("Add new employee");
		addEmpButton.setOnAction(this);
		delEmpButton = new Button("Delete employee");
		delEmpButton.setOnAction(this);
		backToMainButton = new Button("Back");
		backToMainButton.setOnAction(this);
		
		if (runOnlyOnce<1) {
	    	copyOfBank.addDemoEmployees();
		}
	     	
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
	    runOnlyOnce++;
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		HBox hbox = new HBox();
		hbox.setSpacing(5);
		hbox.getChildren().addAll(addEmpButton,delEmpButton);
		vbox.getChildren().addAll(backToMainButton,table,hbox);
	    Scene employeeTableScene = new Scene(vbox);
		BankGUI.getStage().setScene(employeeTableScene);
	}

	@Override
	public void handle(ActionEvent event) {
		//create new employee scene // does not require IF statement here!!!!!!!!!
		if (event.getSource()==addEmpButton) {
			addEmpScene = new AddEmployeeScene(copyOfBank);
			addEmpScene.setAddEmpScene();
		}
		if (event.getSource()==delEmpButton) {
			delEmpScene = new DeleteEmployeeScene(copyOfBank);
			delEmpScene.setDelEmpScene();
		}
		if (event.getSource()==backToMainButton) {
			BankGUI.getStage().setScene(BankGUI.getMainScene());
		}
		
	}
}







