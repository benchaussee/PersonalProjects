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

public class AddEmployeeScene implements EventHandler<ActionEvent> {
	private Bank copyOfBank;
	private Button addButton,backToEmpScene;
	private EmployeeScene empScene;
	private TextField fNameField;
	private TextField lNameField;
	private TextField empNumField;
	private TextField empSalaryField;
		
	public AddEmployeeScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void setAddEmpScene() {
		GridPane gridPane = new GridPane();	
		//Buttons
		backToEmpScene = new Button("Back");
		backToEmpScene.setOnAction(this);
		addButton = new Button("Add");
		addButton.setOnAction(this);
		
		//Header text
		Font font = new Font("Arial", 22);
		Label AddEmployee = new Label("Add Employee-");
		AddEmployee.setFont(font);

		//Labels and TextFields
		Label fNameLabel = new Label("First Name:");
		Label lNameLabel = new Label("Last Name:");
		Label empNumLabel = new Label("Employee Number:");
		Label empSalaryLabel = new Label("Salary:");
		fNameField = new TextField();
		lNameField = new TextField();
		empNumField = new TextField();
		empSalaryField = new TextField();
		
		//Setting size for the pane  
	    gridPane.setMinSize(400, 200); 
	       
	    //Setting the padding  
	    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
//	      
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
	    gridPane.add(addButton, 0, 5);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(backToEmpScene,gridPane);
		Scene addEmployeeScene = new Scene(vbox);
		BankGUI.getStage().setScene(addEmployeeScene);
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==addButton) {
			createNewEmployeeFromGUI();
		}
		if (event.getSource()==backToEmpScene) {
			empScene = new EmployeeScene(copyOfBank);
			empScene.setEmployeeLayoutScene();
		}
		
	}
	public void createNewEmployeeFromGUI() {
		copyOfBank.createNewEmployee(fNameField.getText(), lNameField.getText(), Integer.parseInt(empNumField.getText()), Double.parseDouble(empSalaryField.getText()));
	}

		
}
