package graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import vehicles.Vehicle;

public class CityFrame extends JFrame {

	private static int button_panel_height = 40;
	private static int button_panel_width = 800;
	private static int road_panel_height = 600;
	private static int road_panel_width = 800;
	private static int city_panel_height = 680;
	private static int city_panel_width = 800;
	private static JButton addButton;
	private static AddVehicleDialog addDialog;
	private static Vehicle vehicle;
	private static CityPanel panel;

	public CityFrame(String string) {
		super(string);
		addDialog = new AddVehicleDialog(this,vehicle,panel);
		addDialog.pack();
	}

	public static void main(String[] args) {
		addButton = new JButton("Add Vehicle");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog.setLocationRelativeTo(null);
                addDialog.setVisible(true);
			}
		});
		panel = new CityPanel(addButton);
		CityFrame f = new CityFrame("City");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.add(panel);
		javax.swing.JMenu jMenuFile;
		javax.swing.JMenu jMenuHelp;
		javax.swing.JMenuBar jMenuBar1;
		javax.swing.JMenuItem jMenuItemExit;
		javax.swing.JMenuItem jMenuItemHelp;
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenuFile = new javax.swing.JMenu();
		jMenuItemExit = new javax.swing.JMenuItem();
		jMenuItemHelp = new javax.swing.JMenuItem();
		jMenuHelp = new javax.swing.JMenu();
		jMenuFile.setText("File");
		jMenuHelp.setText("Help");
		jMenuItemExit.setText("Exit");
		jMenuItemHelp.setText("Help");
		jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Home Work 2\n GUI");
			}
		});
		jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Home Work 2\n GUI");
			}
		});
		jMenuFile.add(jMenuItemExit);
		jMenuHelp.add(jMenuItemHelp);
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);
		f.setJMenuBar(jMenuBar1);
		f.setResizable(false);
		f.setSize(new Dimension(city_panel_width,city_panel_height));
		f.setMinimumSize(new Dimension(city_panel_width,city_panel_height));
		f.setMaximumSize(new Dimension(city_panel_width,city_panel_height));
		f.setVisible(true);
	}

}
