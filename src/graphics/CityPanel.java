package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vehicles.*;

public class CityPanel extends JPanel {
	private static ButtonPanel buttonPanel;
	private static  RoadPanel roadPanel;
	private int BUTTONS_HEIGHT = 60;
	
	
	public CityPanel(JButton addButton) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		buttonPanel = new ButtonPanel(addButton);
		
		buttonPanel.setSize(new Dimension(800,40));
		buttonPanel.setMinimumSize(new Dimension(800,40));
		buttonPanel.setMaximumSize(new Dimension(800,40));
		roadPanel = new RoadPanel();
		roadPanel.setSize(new Dimension(800,600));
		roadPanel.setMinimumSize(new Dimension(800,600));
		roadPanel.setMaximumSize(new Dimension(800,600));
		add(roadPanel);
		add(buttonPanel);
	}

	RoadPanel getRoad() {
		return roadPanel;
	}
	
	
}
