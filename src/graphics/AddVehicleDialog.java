package graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import vehicles.Car;
import vehicles.Color;
import vehicles.EngineType;
import vehicles.Vehicle;

public class AddVehicleDialog extends JDialog  implements ActionListener,
PropertyChangeListener {

	private JComboBox comboVehicle;
	private JComboBox comboColor;

	private String magicWord;
	private JOptionPane optionPane;
	private String btnString1 = "Add";
	private String btnString2 = "Cancel";
	private String[] vehicleTypes = { "Benzine Car","Solar Car", "Bike", "Carriage" };
	private String[] colorStrings;
	private Vehicle vehicle;
	private RoadPanel panel;
	/**
	 * Returns null if the typed string was invalid; otherwise, returns the string
	 * as the user entered it.
	 */

	/** Creates the reusable dialog. 
	 * @param vehicle */
	public AddVehicleDialog(JFrame aFrame, Vehicle vehicle,CityPanel panel) {
		super(aFrame, true);
		this.vehicle = vehicle;
		this.panel = panel.getRoad();
		colorStrings = Arrays.toString(Color.values()).replaceAll("^.|.$", "").split(", ");
		comboColor = new JComboBox(colorStrings);
		comboColor.setEditable(false);
		comboColor.setName("colorbox");
		comboVehicle = new JComboBox(vehicleTypes);
		comboVehicle.setEditable(false);
		comboVehicle.setName("vehiclebox");
		comboColor.addActionListener(this);
		comboVehicle.addActionListener(this);
		setTitle("Add vehicle");
		// Create an array of the text and components to be displayed.
		String msgString1 = "Choose Vehicle and it's color";
		
		Object[] array = { msgString1, comboVehicle , comboColor};

		// Create an array specifying the number of dialog buttons
		// and their text.
		Object[] options = { btnString1, btnString2 };

		// Create the JOptionPane.
		optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options,
				options[0]);

		// Make this dialog display it.
		setContentPane(optionPane);

		// Handle window closing correctly.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		 optionPane.addPropertyChangeListener(this);

	}

	@Override
	 /** This method reacts to state changes in the option pane. */
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();
 
        if (isVisible()
         && (e.getSource() == optionPane)
         && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
             JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();
 
            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }
 
            //Reset the JOptionPane's value.
            //If you don't do this, then if the user
            //presses the same button next time, no
            //property change event will be fired.
            optionPane.setValue(
                    JOptionPane.UNINITIALIZED_VALUE);
 
            if (btnString1.equals(value)) {
                  System.out.println(comboColor.getSelectedItem());
                  System.out.println(comboVehicle.getSelectedItem());
                  vehicle = new Car(comboColor.getSelectedItem().toString(),EngineType.BENZINE,panel);
                  setVisible(false);
            } else { //user closed dialog or clicked cancel
                setVisible(false);
            }
        }
    }
 
 
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox subject = (JComboBox) e.getSource();
		System.out.println(subject.getName());
		
	}

}
