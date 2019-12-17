package Bank;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 
public class BankGUI extends Application implements EventHandler<ActionEvent>  {
	private Bank mainBank;
	private Button empLayoutButton,custLayoutButton,backButton,addEmpButton,delEmpButton,
		addCustButton,backToCustLayoutButton,confirmNewCust,deleteCustSceneButton,delCustButton,
		depWithButton,depositButton,withdrawButton,addEmployeeLayoutButton,backToShowEmp;
	private AddCustomerScene addCustLayout;
	private AddEmployeeScene addEmpLayout;
	private CustomerScene custLayout;
	private DelCustomerScene delCustomerLayout;
	private DepositWithdrawScene depositWithdrawLayout;
	private EmployeeScene empLayout;
	private HBox employeeHbox;
	private Label openingLabel;
	private static Scene mainScene;
	private Scene employeeTableScene,customerTableScene,addCustScene,delCustScene,
		depWithScene,addEmployeeScene;
	private static Stage stage;
	private VBox mainVbox,employeeVbox,customerVbox,addCustVbox,delCustVbox;
	

	public static void main(String[] args) {
    	Application.launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
    	//Bank object
    	mainBank = new Bank("Bank of Snapchat");
    	Font labelFont = new Font("Arial", 22);

    	//Title of the window
    	stage = primaryStage;
    	stage.setTitle("Your Bank");
		openingLabel = new Label("Welcome to " + mainBank.getBankName());
		openingLabel.setFont(labelFont);

		//BUTTONS
		empLayoutButton = new Button("Employees");
		addEmpButton = new Button("Add new employee");//delete
		delEmpButton = new Button("Delete employee");//delete
		custLayoutButton = new Button("Customers");
		backButton = new Button("Back");
		addCustButton = new Button("Add Customer");
		backToCustLayoutButton = new Button("Back");//delete
		confirmNewCust = new Button("Corfirm New Customer");//delete
		deleteCustSceneButton = new Button("Delete Customer");
		delCustButton = new Button("Delete");//deltete
		depWithButton = new Button("Deposit/Withdraw");
		depositButton = new Button("Deposit");//delete
		withdrawButton = new Button("Withdraw");//delete
		backToShowEmp = new Button("Back");//delete
		//Button actions
		empLayoutButton.setOnAction(this);
		addEmpButton.setOnAction(this);//delete
		delEmpButton.setOnAction(this);//delete
		backButton.setOnAction(this);
		custLayoutButton.setOnAction(this);
		addCustButton.setOnAction(this);
		backToCustLayoutButton.setOnAction(this);//delete
		confirmNewCust.setOnAction(this);//delete
		deleteCustSceneButton.setOnAction(this);	
		delCustButton.setOnAction(this);//delete
		depWithButton.setOnAction(this);
		depositButton.setOnAction(this);//delete
		withdrawButton.setOnAction(this);//delete
		backToShowEmp.setOnAction(this);//delete

		// Put everything in the VBox
		mainVbox = new VBox(openingLabel, empLayoutButton, custLayoutButton);
		mainVbox.setSpacing(30);
		mainVbox.setAlignment(Pos.CENTER);

		//set the scene
		mainScene = new Scene(mainVbox,300,250);

    	//show the scene
    	stage.setScene(mainScene);
    	stage.show();
    }
	@Override
	public void handle(ActionEvent event) {
		//show employees scene
		if (event.getSource()== empLayoutButton ||event.getSource()==backToShowEmp) {
			empLayout = new EmployeeScene(mainBank);
			empLayout.setEmployeeLayoutScene();
		}
		//show customers scene
		if (event.getSource()== custLayoutButton) {
			custLayout = new CustomerScene(mainBank);
			custLayout.setCustomerLayoutStage();
		}
		
		
	}
	public static Stage getStage() {
		return stage;
	}
	public static Scene getMainScene() {
		return mainScene;
	}
	
}




