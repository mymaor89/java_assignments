package graphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RoadPanel extends JPanel{
	BackgroundPanel bgPanel;
	public RoadPanel() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("./resources/cityBackground.png"));
			image = RoadPanel.resize(image, 800,640);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bgPanel = new BackgroundPanel(image,BackgroundPanel.TILED );
		add(bgPanel);
		setVisible(true);
	}
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
}
