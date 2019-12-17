package Bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
//THIS IS THE CLASS WHERE I GOT THE BUTTONS TO WORK IN THE DAMN CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class AddEmployeeScene implements EventHandler<ActionEvent> {
	private Bank copyOfBank;
	private Button create,backToShowEmp;
	private GridPane gridPane;
	private Label fNameLabel;
	private Label lNameLabel;
	private Label empNumLabel;
	private Label empSalaryLabel;
	private Label AddEmployee;
	private TextField fNameField;
	private TextField lNameField;
	private TextField empNumField;
	private TextField empSalaryField;
		
	public AddEmployeeScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void setAddEmpScene() {
		gridPane = new GridPane();	
		backToShowEmp = new Button("Back");
		backToShowEmp.setOnAction(this);
			
		Font font = new Font("Arial", 22);
		
		create = new Button("Create");
		create.setOnAction(this);
		
		AddEmployee = new Label("Add Employee-");
		AddEmployee.setFont(font);
		fNameLabel = new Label("First Name:");
		lNameLabel = new Label("Last Name:");
		empNumLabel = new Label("Employee Number:");
		empSalaryLabel = new Label("Salary:");
		fNameField = new TextField();
		lNameField = new TextField();
		empNumField = new TextField();
		empSalaryField = new TextField();
		
		//Setting size for the pane  
	    gridPane.setMinSize(400, 200); 
	       
	    //Setting the padding  
	    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      
	    //Setting the vertical and horizontal gaps between the columns 
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);       
	      
	    //Setting the Grid alignment 
	    gridPane.setAlignment(Pos.CENTER); 
	       
	    //Arranging all the nodes in the grid 
	    gridPane.add(AddEmployee, 0, 0);
	    gridPane.add(fNameLabel, 0, 1); 
	    gridPane.add(fNameField, 1, 1); 
	    gridPane.add(lNameLabel, 0, 2); 
	    gridPane.add(lNameField, 1, 2);
	    gridPane.add(empNumLabel, 0, 3); 
	    gridPane.add(empNumField, 1, 3);
	    gridPane.add(empSalaryLabel, 0, 4); 
	    gridPane.add(empSalaryField, 1, 4);
	    gridPane.add(create, 0, 5);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(backToShowEmp,gridPane);
		Scene addEmployeeScene = new Scene(vbox);
		BankGUI.getStage().setScene(addEmployeeScene);
	}
	
	public void createNewEmployeeFromGUI() {
		copyOfBank.createNewEmployee(fNameField.getText(), lNameField.getText(), Integer.parseInt(empNumField.getText()), Double.parseDouble(empSalaryField.getText()));
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==create) {
			createNewEmployeeFromGUI();
		}
		
	}
		
}
