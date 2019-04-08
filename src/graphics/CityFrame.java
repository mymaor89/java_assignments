package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CityFrame extends JFrame {

	private static final int WIDTH = 1024;
	private static final int HEIGHT = 700;
	private static int panel_height = HEIGHT;
	private static int panel_width = WIDTH;

	// private CityPanel panel;
	// private menuFile;
	// private JMenu menuHelp;
	// private JMenuItem exitItem,helpItem;

	public CityFrame(String string) {
		super(string);
	}

	public static void main(String[] args) {
		CityFrame f = new CityFrame("City");
		f.setSize(WIDTH, HEIGHT);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		jMenuItemExit.setText("Exit");
		jMenuItemHelp.setText("Help");
		jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		jMenuFile.add(jMenuItemExit);
		jMenuHelp.add(jMenuItemHelp);
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);

		f.setJMenuBar(jMenuBar1);
		/*
		 * JMenuBar bar = new JMenuBar(); JMenu menuFile = new JMenu("File"); JMenu
		 * menuHelp = new JMenu("Help"); JMenuItem exitItem = new JMenu("Exit");
		 * JMenuItem helpItem = new JMenu("Help");
		 * 
		 * exitItem.setActionCommand("Exit"); helpItem.setActionCommand("Help");
		 * exitItem.addActionListener(new java.awt.event.ActionListener() { public void
		 * actionPerformed(java.awt.event.ActionEvent evt) { System.exit(0); } });
		 * menuFile.add(exitItem); menuHelp.add(helpItem); bar.add(menuFile);
		 * bar.add(menuHelp); f.setJMenuBar(bar);
		 */
		f.setResizable(false);
		CityPanel panel = new CityPanel(panel_width, panel_height);
		f.add(panel);
		f.pack();
		f.setVisible(true);

	}

}
