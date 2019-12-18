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

public class DelCustomerScene implements EventHandler<ActionEvent>{
	private Bank copyOfBank;
	private Button backToCustSceneButton,delCustButton;
	private CustomerScene custScene;
	private GridPane gridPane;
	private Label acctNumLabel,deleteCustomer;
	private TextField acctNumField;

		
	public DelCustomerScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void setDelCustScene() {
		gridPane = new GridPane();	
		//Buttons
		backToCustSceneButton = new Button("Back");
		backToCustSceneButton.setOnAction(this);
		delCustButton = new Button("Delete");
		delCustButton.setOnAction(this);
			
		//Header Label
		Font labelFont = new Font("Arial", 22);
		Label deleteCustomer = new Label("Delete Customer-");
		deleteCustomer.setFont(labelFont);

		//Acct Num Label
		Label acctNumLabel = new Label("Account Number:");
		acctNumField = new TextField();
		
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
	    gridPane.add(deleteCustomer, 0, 0);
	    gridPane.add(acctNumLabel, 0, 3); 
	    gridPane.add(acctNumField, 1, 3); 
		VBox vbox = new VBox();
		vbox.getChildren().addAll(backToCustSceneButton,gridPane,delCustButton);
		Scene delCustScene = new Scene(vbox);
		BankGUI.getStage().setScene(delCustScene);
	}
	
	public void deleteCustFromGUI() {
		copyOfBank.removeCustomer(Integer.parseInt(acctNumField.getText()));
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==delCustButton) {
			deleteCustFromGUI();
		}
		if (event.getSource()==backToCustSceneButton) {
			custScene = new CustomerScene(copyOfBank);
			custScene.setCustomerLayoutStage();
		}
	}
		
}