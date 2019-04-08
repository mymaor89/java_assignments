package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CityFrame extends JFrame  {
	
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 700;
	private static int panel_height = HEIGHT;
	private static int panel_width = WIDTH;
	//private  CityPanel panel;
	//private   menuFile;
	//private  JMenu menuHelp;
	//private  JMenuItem exitItem,helpItem;

	public CityFrame(String string) {
		super(string);
	}
	public static void main(String[] args) {
		CityFrame f = new CityFrame("City");
		f.setSize(WIDTH,HEIGHT);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar bar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuHelp = new JMenu("Help");
		JMenuItem exitItem = new JMenu("Exit");
		JMenuItem helpItem = new JMenu("Help");
		
		exitItem.setActionCommand("Exit");
		helpItem.setActionCommand("Help");
		menuFile.add(exitItem);
		menuHelp.add(helpItem);
		bar.add(menuFile);
		bar.add(menuHelp);
		f.setJMenuBar(bar);
		
		f.setResizable(false);
		
		exitItem.setEnabled(true);
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("dasfvb");
				System.exit(0);
			}
		});
		f.setVisible(true);
		CityPanel panel = new CityPanel(panel_width,panel_height);
		f.add(panel);
		
	}
	

}
