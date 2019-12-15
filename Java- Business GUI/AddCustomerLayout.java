package Bank;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddCustomerLayout {
	private Bank copyOfBank;
	private Scene custScene;
	private GridPane gridPane;
	private Label fNameLabel;
	private Label lNameLabel;
	private Label acctNumLabel;
	private Label balLabel;
	private TextField fNameField;
	private TextField lNameField;
	private TextField acctNumField;
	private TextField balField;
		
	public AddCustomerLayout(Bank someBank) {
		copyOfBank = someBank;	
	}
	
	public void generateAddCustomerLayout() {
		gridPane = new GridPane();	
			
		//First
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
	    gridPane.add(fNameLabel, 0, 0); 
	    gridPane.add(fNameField, 1, 0); 
	    gridPane.add(lNameLabel, 0, 1); 
	    gridPane.add(lNameField, 1, 1);
	    gridPane.add(acctNumLabel, 0, 2); 
	    gridPane.add(acctNumField, 1, 2);
	    gridPane.add(balLabel, 0, 3); 
	    gridPane.add(balField, 1, 3);
	}
	
	public void createNewCustomerFromGUI() {
		copyOfBank.createCustomerAccount("new","customer",11111,1200);
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
		
}
















