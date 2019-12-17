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

public class CustomerScene implements EventHandler<ActionEvent> {
	private AddCustomerScene addCustLayout;
	private DelCustomerScene delCustLayout;
	private DepositWithdrawScene depWithScene;
	private Bank copyOfBank;
	private Button addCustSceneButton,deleteCustSceneButton,depWithButton,backToMainButton;
	private TableView<BankCustomer> table;
	private static int runOnlyOnce;
	
	public CustomerScene(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void setCustomerLayoutStage() {
		addCustSceneButton = new Button("Add Customer");
		addCustSceneButton.setOnAction(this);
		deleteCustSceneButton = new Button("Delete Customer");
		deleteCustSceneButton.setOnAction(this);
		depWithButton = new Button("Deposit/Withdraw");
		depWithButton.setOnAction(this);
		backToMainButton = new Button("Back");
		backToMainButton.setOnAction(this);

		
		//Clearing tables and re-adding
	//	Bank.clearCustomerTable();
	//	copyOfBank.clearCustomerList();
		if (runOnlyOnce < 1) {
		copyOfBank.addDemoCustomers();
		}
	
		//First Name Column
		TableColumn<BankCustomer,String> fNameCol = new TableColumn<>("First Name");
		fNameCol.setMinWidth(200);
		fNameCol.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
		//Last Name Column
		TableColumn<BankCustomer,String> lNameCol = new TableColumn<>("Last Name");
		lNameCol.setMinWidth(200);
		lNameCol.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));   	
		//Employee Number Column	
		TableColumn<BankCustomer,Integer> acctNumCol = new TableColumn<>("Account Number");
		acctNumCol.setMinWidth(200);
		acctNumCol.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));   
		//Salary Column
		TableColumn<BankCustomer,Double> balanceCol = new TableColumn<>("Balance");
		balanceCol.setMinWidth(200);
		balanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));   	   		
	
		table = new TableView<>();
		table.setItems(Bank.getCustomerObservableList());
		table.getColumns().addAll(fNameCol,lNameCol,acctNumCol,balanceCol);
		HBox hbox = new HBox();
		hbox.setSpacing(5);
		hbox.getChildren().addAll(addCustSceneButton,deleteCustSceneButton,depWithButton);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.getChildren().addAll(backToMainButton,table,hbox);
		Scene customerTableScene = new Scene(vbox);
		BankGUI.getStage().setScene(customerTableScene);
		runOnlyOnce++;
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==addCustSceneButton) {
			addCustLayout = new AddCustomerScene(copyOfBank);
			addCustLayout.setAddCustomerLayoutScene();
		}
		if (event.getSource()==deleteCustSceneButton) {
			delCustLayout = new DelCustomerScene(copyOfBank);
			delCustLayout.setDelCustScene();
		}
		if (event.getSource()==depWithButton) {
			depWithScene = new DepositWithdrawScene(copyOfBank);
			depWithScene.setDepWithScene();
		}
		if (event.getSource()==backToMainButton) {
			BankGUI.getStage().setScene(BankGUI.getMainScene());
		}
		
	}

}














