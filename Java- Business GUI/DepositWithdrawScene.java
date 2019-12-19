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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DepositWithdrawScene implements EventHandler<ActionEvent>{
	private Bank copyOfBank;
	private Button depositButton,withdrawButton,backToCustLayoutButton;
	private CustomerScene custScene;
	private GridPane gridPane;
	private Label amountLabel,acctNumLabel;
	private TextField amountField,acctNumField;

		
	public DepositWithdrawScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void setDepWithScene() {
		//GridPane and Buttons
		gridPane = new GridPane();	
		depositButton = new Button("Deposit");
		depositButton.setOnAction(this);
		withdrawButton = new Button("Withdraw");
		withdrawButton.setOnAction(this);
		backToCustLayoutButton = new Button("Back");
		backToCustLayoutButton.setOnAction(this);
			
		//Labels and Fields
		acctNumLabel = new Label("Account Number:");
		amountLabel = new Label("Amount:");
		acctNumField = new TextField();
		amountField = new TextField();
		
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
	    gridPane.add(acctNumLabel, 0, 0); 
	    gridPane.add(acctNumField, 1, 0); 
	    gridPane.add(amountLabel, 0, 1);
	    gridPane.add(amountField, 1, 1);

	    //organizing the scene
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.getChildren().addAll(depositButton,withdrawButton);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(backToCustLayoutButton,gridPane,hbox);
		Scene depWithScene = new Scene(vbox);
		BankGUI.getStage().setScene(depWithScene);
	}
	
	public void depositFromGUI() {
		copyOfBank.deposit(Integer.parseInt(acctNumField.getText()), Double.parseDouble(amountField.getText()));
	}
	public void withdrawFromGUI() {
		copyOfBank.withdraw(Integer.parseInt(acctNumField.getText()), Double.parseDouble(amountField.getText()));

	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==depositButton) {
			depositFromGUI();
		}
		if (event.getSource()==withdrawButton) {
			withdrawFromGUI();
		}
		if (event.getSource()==backToCustLayoutButton) {
			custScene = new CustomerScene(copyOfBank);
			custScene.setCustomerLayoutStage();
		}
	}
		
}
