package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MyMenu extends JMenuBar  implements ActionListener {
	JMenu menuFile, menuHelp;
	JMenuItem exitItem,helpItem;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource().toString());
		
	}

	public MyMenu() {
		super();
		menuFile = new JMenu("File");
		menuHelp = new JMenu("Help");
		exitItem = new JMenu("Exit");
		helpItem = new JMenu("Help");
		exitItem.addActionListener(this);
		helpItem.addActionListener(this);
		menuFile.add(exitItem);
		menuHelp.add(helpItem);
		add(menuFile);
		add(menuHelp);
	}

}
