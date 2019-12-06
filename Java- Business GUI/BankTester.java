package Bank;

import javax.swing.JFrame;

public class BankTester {

	public static void main(String[] args) {
		
		// Everything needed to launch GUI
		JFrame frame = new JFrame ("My Bank Account");
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    MyBankGUI gui = new MyBankGUI();
	    frame.getContentPane().add(gui);
	    frame.pack();
	    frame.setVisible(true);
	    
	}

}
