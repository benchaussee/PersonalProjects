package Bank;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerLayout {
	
	private Scene custScene;
	private TableView<BankCustomer> table;
	Bank copyOfBank;
	
	public CustomerLayout(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void generateCustomerTable() {
		//Clearing tables and re-adding
	//	Bank.clearCustomerTable();
	//	copyOfBank.clearCustomerList();
		copyOfBank.addDemoCustomers();
	
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
	
		//Creating the table itself
		table = new TableView<>();
		table.setItems(Bank.getCustomerObservableList());
		table.getColumns().addAll(fNameCol,lNameCol,acctNumCol,balanceCol);
	}

	public TableView<BankCustomer> getCustomerLayout(){
		return table;
	}

}














