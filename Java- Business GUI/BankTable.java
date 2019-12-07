package Bank;

import javafx.application.Application;
import javafx.stage.Stage;

 
public class BankTable extends Application  {


    public void start(Stage stage) throws Exception {
    	stage.setTitle("Hello World");
    	stage.show();
    	
    	Stage stage2 = new Stage();
    	stage2.setTitle("Second Window");
    	stage2.setWidth(400);
    	stage2.setHeight(300);
    	stage2.setX(200);
    	stage2.setY(0);
    	
    	
    	stage2.show();
    }


}
