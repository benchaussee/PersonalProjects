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

public class AddCustomerScene implements EventHandler<ActionEvent>{
	private static Bank copyOfBank;
	private Button backToCustLayoutButton,confirmNewCust;
	private CustomerScene custLayout;
	private GridPane gridPane;
	private Label fNameLabel;
	private Label lNameLabel;
	private Label acctNumLabel;
	private Label balLabel;
	private Label AddCustomer;
	private TextField fNameField;
	private TextField lNameField;
	private TextField acctNumField;
	private TextField balField;
		
	public AddCustomerScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void setAddCustomerLayoutScene() {
		gridPane = new GridPane();	
		backToCustLayoutButton = new Button("Back");
		backToCustLayoutButton.setOnAction(this);
		confirmNewCust = new Button("Corfirm New Customer");
		confirmNewCust.setOnAction(this);
			
		//First
		Font font = new Font("Arial", 22);
		AddCustomer = new Label("Add Customer-");
		AddCustomer.setFont(font);
		fNameLabel = new Label("First Name:");
		lNameLabel = new Label("Last Name:");
		acctNumLabel = new Label("Account Number:");
		balLabel = new Label("Balance:");
		fNameField = new TextField();
		lNameField = new TextField();
		acctNumField = new TextField();
		balField = new TextField();
		
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
	    gridPane.add(AddCustomer, 0, 0);
	    gridPane.add(fNameLabel, 0, 1); 
	    gridPane.add(fNameField, 1, 1); 
	    gridPane.add(lNameLabel, 0, 2); 
	    gridPane.add(lNameField, 1, 2);
	    gridPane.add(acctNumLabel, 0, 3); 
	    gridPane.add(acctNumField, 1, 3);
	    gridPane.add(balLabel, 0, 4); 
	    gridPane.add(balField, 1, 4);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(backToCustLayoutButton,gridPane,confirmNewCust);
		Scene addCustScene = new Scene(vbox);
		BankGUI.getStage().setScene(addCustScene);
	}
	
	public void createNewCustomerFromGUI() {
		copyOfBank.createCustomerAccount(fNameField.getText().toString(),lNameField.getText().toString(),Integer.parseInt(acctNumField.getText().toString()),Double.parseDouble(balField.getText().toString()));
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==backToCustLayoutButton) {
			custLayout = new CustomerScene(copyOfBank);
			custLayout.setCustomerLayoutStage();
		}
		if (event.getSource()==confirmNewCust) {
			createNewCustomerFromGUI();
		}
	}
		
}
















