package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonPanel extends javax.swing.JPanel {
	private JButton[] buttons;
	private JButton addButton;
	private static AddVehicleDialog addDialog;
	private final static String[] btnStrings  = {"Add Vehicle", "Clear","Fuel/Food", "Info","Exit" };
	public ButtonPanel(JButton addButton) {
		super();
		  buttons = new JButton [5];  
		  setLayout (new GridLayout(1,0));
		  this.addButton = addButton;
		  add(addButton);
		   for (int i = 1;i<5;i++) {  
		      buttons[i] = new JButton (); 
		      buttons[i].setText(btnStrings[i]);
		      add (buttons[i]);  
		    }  
		   
		  buttons[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		setVisible(true);  
		
	}
}
