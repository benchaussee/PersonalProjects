package Bank;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// GUI Class
public class MyBankGUI extends JPanel{
	
	// Instance variables
	private JLabel employeeName;
	private JTextArea employeeNameText;
	Bank aBank = new Bank("Twitch Bank");
	
	// Constructor  
	public MyBankGUI() {

		//Layout of the gui 
		employeeName = new JLabel("Employee");
		employeeNameText = new JTextArea(10, 50); 		
 		setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(800, 600));    
		add(employeeName);
		add(employeeNameText);
        
		//Company-Specific information	
        addEmployees(); 
		employeeNameText.setText(aBank.returnAllEmployeeInfo());
	}

	// Methods to add company-specific information.
	public void addEmployees() {
		aBank.createNewEmployee("b", "monsterous", 10245864, 100000);
	}
	
}
