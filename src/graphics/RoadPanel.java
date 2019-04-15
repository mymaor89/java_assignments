package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import vehicles.BenzineEngine;
import vehicles.Car;
import vehicles.EngineType;

public class RoadPanel extends JPanel {
	// private static BackgroundPanel bgPanel;
	private static BufferedImage image;
	Car car;

	public RoadPanel() {
		setSize(800, 600);
		try {
			image = ImageIO.read(new File("./images/cityBackground.png"));
			image = RoadPanel.resize(image, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// bgPanel = new BackgroundPanel(image,BackgroundPanel.TILED );
		// add(bgPanel);
		setVisible(true);
		car = new Car("GREEN", EngineType.BENZINE, this);
		//MoveThread moveThread = new MoveThread(car, newSize, this);
		//Thread t = new Thread(moveThread);
		//t.start();
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,this);
		if (car!= null) {
			car.drawObject(g);
		}
	}

	public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

		int original_width = imgSize.width;
		int original_height = imgSize.height;
		int bound_width = boundary.width;
		int bound_height = boundary.height;
		int new_width = original_width;
		int new_height = original_height;

		// first check if we need to scale width
		if (original_width > bound_width) {
			// scale width to fit
			new_width = bound_width;
			// scale height to maintain aspect ratio
			new_height = (new_width * original_height) / original_width;
		}

		// then check if we need to scale even with the new height
		if (new_height > bound_height) {
			// scale height to fit instead
			new_height = bound_height;
			// scale width to maintain aspect ratio
			new_width = (new_height * original_width) / original_height;
		}

		return new Dimension(new_width, new_height);
	}
}
