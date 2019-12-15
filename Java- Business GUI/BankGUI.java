package Bank;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 
public class BankGUI extends Application implements EventHandler<ActionEvent>  {
	private Bank mainBank;
	private Button employeeButton,customerButton,backButton,addEmpButton,delEmpButton,addCustButton,backToCustLayoutButton,confirmNewCust;
	private AddCustomerLayout addCustLayout;
	private CustomerLayout custLayout;
	private EmployeeLayout empTable;
	private Font labelFont = new Font("Arial", 22);
	private HBox employeeHbox;
	private Label openingLabel;
	private Scene mainScene,employeeTableScene,customerTableScene,addCustScene;
	private Stage stage;
	private VBox mainVbox,employeeVbox,customerVbox,addCustVbox;
	

	public static void main(String[] args) {
    	Application.launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
    	//Bank object
    	mainBank = new Bank("Bank of Twitch");

    	//Title of the window
    	stage = primaryStage;
    	stage.setTitle("Your Bank");
		openingLabel = new Label("Welcome to " + mainBank.getBankName());
		openingLabel.setFont(labelFont);

		//BUTTONS
		employeeButton = new Button("Employees");
		addEmpButton = new Button("Add new employee");
		delEmpButton = new Button("Delete employee");
		customerButton = new Button("Customers");
		backButton = new Button("Back");
		addCustButton = new Button("Add Customer");
		backToCustLayoutButton = new Button("Back");
		confirmNewCust = new Button("Create New Customer");
	
		//Button actions
		employeeButton.setOnAction(this);
		addEmpButton.setOnAction(this);
		delEmpButton.setOnAction(this);
		backButton.setOnAction(this);
		customerButton.setOnAction(this);
		addCustButton.setOnAction(this);
		backToCustLayoutButton.setOnAction(this);
		confirmNewCust.setOnAction(this);
		
		// Put everything in the VBox
		mainVbox = new VBox(openingLabel, employeeButton, customerButton);
		mainVbox.setSpacing(20);
		mainVbox.setAlignment(Pos.TOP_CENTER);

		//set the scene
		mainScene = new Scene(mainVbox,300,250);

    	//show the scene
    	stage.setScene(mainScene);
    	stage.show();
    }
	@Override
	public void handle(ActionEvent event) {
		//show employee table
		if (event.getSource()== employeeButton) {
			empTable = new EmployeeLayout(mainBank);
			empTable.generateEmployeeTable();
			employeeVbox = new VBox();
			employeeVbox.setSpacing(10);
			employeeHbox = new HBox();
			employeeHbox.setSpacing(5);
			employeeHbox.getChildren().addAll(addEmpButton,delEmpButton);
	    	employeeVbox.getChildren().addAll(backButton,empTable.getEmployeeTable(),employeeHbox);
	    	employeeTableScene = new Scene(employeeVbox);
			stage.setScene(employeeTableScene);
		}
		//show customer table
		if (event.getSource()== customerButton || event.getSource()==backToCustLayoutButton) {
			custLayout = new CustomerLayout(mainBank);
			custLayout.generateCustomerTable();
			customerVbox = new VBox();
			customerVbox.setSpacing(10);
			customerVbox.getChildren().addAll(backButton,custLayout.getCustomerLayout(),addCustButton);
			customerTableScene = new Scene(customerVbox);
			stage.setScene(customerTableScene);
		}
		//go back to main
		if (event.getSource()==backButton) {
			stage.setScene(mainScene);
		}
		//Add-customer Scene
		if (event.getSource()==addCustButton) {
			addCustVbox = new VBox();
			addCustLayout = new AddCustomerLayout(mainBank);
			addCustLayout.generateAddCustomerLayout();
			addCustVbox.getChildren().addAll(backToCustLayoutButton,addCustLayout.getGridPane(),confirmNewCust);
			addCustScene = new Scene(addCustVbox);
			stage.setScene(addCustScene);
		}
		//Creating a new Customer
		if (event.getSource()==confirmNewCust) {
			addCustLayout = new AddCustomerLayout(mainBank);
			addCustLayout.createNewCustomerFromGUI();
		}
		
	}
	
}








