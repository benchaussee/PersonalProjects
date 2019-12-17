package Bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DeleteEmployeeScene implements EventHandler<ActionEvent> {
	private Bank copyOfBank;
	private Button delEmpButton,backToEmpLayoutButton;
	private EmployeeScene empLayout;
	private GridPane gridPane;
	private Label empNumLabel,delEmpLabel;
	private TextField empNumField;
	private Font labelFont = new Font("Arial", 22);

		
	public DeleteEmployeeScene(Bank someBank) {
		empLayout = new EmployeeScene(someBank);
		copyOfBank = someBank;	
	}
	
	public void setDelEmpScene() {
		//pane
		gridPane = new GridPane();	
		//Buttons
		delEmpButton = new Button("Delete");
		delEmpButton.setOnAction(this);
		backToEmpLayoutButton = new Button("Back");
		backToEmpLayoutButton.setOnAction(this);
			
		//header label
		delEmpLabel = new Label("Delete Employee-");
		delEmpLabel.setFont(labelFont);
		
		//employee label and text field
		empNumLabel = new Label("Employee Number:");
		empNumField = new TextField();
		
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
	    gridPane.add(delEmpLabel, 0, 0);
	    gridPane.add(empNumLabel, 0, 1); 
	    gridPane.add(empNumField, 1, 1); 
	    gridPane.add(delEmpButton, 0, 2);
	    
	    VBox vbox = new VBox();
	    vbox.getChildren().addAll(backToEmpLayoutButton,gridPane);
	    Scene delEmpScene = new Scene(vbox);
	    BankGUI.getStage().setScene(delEmpScene);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==delEmpButton) {
			deleteEmpFromGUI();
		}
		if (event.getSource()==backToEmpLayoutButton) {
			empLayout = new EmployeeScene(copyOfBank);
			empLayout.setEmployeeLayoutScene();
		}
	}	

	public void deleteEmpFromGUI() {
		copyOfBank.removeEmployee(Integer.parseInt(empNumField.getText()));
	}
	
}