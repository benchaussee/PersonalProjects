package Bank;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 
public class BankGUI extends Application implements EventHandler<ActionEvent>  {
	private Bank mainBank;
	private Button empSceneButton,custSceneButton;
	private CustomerScene custScene;
	private EmployeeScene empScene;
	private static Scene mainScene;
	private static Stage stage;
	

	public static void main(String[] args) {
    	Application.launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
    	//stage/window
    	stage = primaryStage;
    	stage.setTitle("Your Bank");

    	//Making primary Bank object
    	mainBank = new Bank("Bank of Snapchat");

    	//label on home screen
    	Image snapImage = new Image(new FileInputStream("D:\\Pictures\\snpachapt.png"));
    	ImageView imageview = new ImageView(snapImage);
    	
		Label openingLabel = new Label("Welcome to " + mainBank.getBankName());
		Font labelFont = new Font("Arial", 22);
		openingLabel.setFont(labelFont);

		//BUTTONS
		empSceneButton = new Button("Employees");
		custSceneButton = new Button("Customers");
		//Button actions
		empSceneButton.setOnAction(this);
		custSceneButton.setOnAction(this);

		// VBox as parent node
		VBox vbox = new VBox();
		vbox = new VBox(imageview,openingLabel, empSceneButton, custSceneButton);
		vbox.setSpacing(30);
		vbox.setAlignment(Pos.CENTER);

		//set the scene
		mainScene = new Scene(vbox,330,280);

    	//show the scene
    	stage.setScene(mainScene);
    	stage.show();
    }
	@Override
	public void handle(ActionEvent event) {
		//show employees scene
		if (event.getSource()== empSceneButton) {
			empScene = new EmployeeScene(mainBank);
			empScene.setEmployeeLayoutScene();
		}
		//show customers scene
		if (event.getSource()== custSceneButton) {
			custScene = new CustomerScene(mainBank);
			custScene.setCustomerLayoutStage();
		}
	}

	//static methods
	public static Stage getStage() {
		return stage;
	}
	public static Scene getMainScene() {
		return mainScene;
	}
	
}
