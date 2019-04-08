package graphics;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CityPanel extends JPanel {
	private ButtonPanel buttonPanel;
	private RoadPanel roadPanel;
	private int BUTTONS_HEIGHT = 60;
	public CityPanel(int panel_width, int panel_height) {
		super();
		setSize(panel_width, panel_height);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		buttonPanel = new ButtonPanel( panel_width, BUTTONS_HEIGHT);
		roadPanel = new RoadPanel();
		add(roadPanel);
		add(buttonPanel);
	}

	
	
	
}
