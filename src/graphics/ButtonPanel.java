package graphics;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ButtonPanel extends javax.swing.JPanel {
	JButton[] buttons;
	private final static String[] btnStrings  = {"Add Vehicle", "Clear","Fuel/Food", "Info","Exit" };
	public ButtonPanel(int panel_width, int buttons_height) {
		super();
		  buttons = new JButton [5];  
		    
		   for (int i = 0;i<5;i++) {  
		      buttons[i] = new JButton ("Button " + (i + 1)); 
		      buttons[i].setText(btnStrings[i]);
		      add (buttons[i]);  
		    }  
		  
		setLayout (new BoxLayout (this, BoxLayout.X_AXIS));  
		setSize(panel_width,buttons_height);  
		setVisible(true);  
	}
}
