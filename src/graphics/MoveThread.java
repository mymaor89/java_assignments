package graphics;

import java.awt.Dimension;

import javax.swing.JLabel;

import vehicles.Location;
import vehicles.Orientation;
import vehicles.Vehicle;

public class MoveThread implements Runnable {
	private JLabel vLabel;
	private Vehicle vehicle;
	private RoadPanel rp;
	private Dimension newSize;
	@Override
	public void run() {
		Location loc = vehicle.getLocation();
		while(true) {
		//if (true) {
			loc.setX(loc.getX()+vehicle.getSpeed());
			if(loc.getX()+newSize.getWidth()>= rp.getWidth()) {
				//replace Image
				//change direction
			}
			else if(loc.getY()+newSize.getHeight()>= rp.getHeight()) {
					//replace Image
					//change direction
			}else {
			vehicle.setLocation(loc);
			rp.invalidate();
			}
		//}
		 try {
		      Thread.sleep(100);
		      } catch (InterruptedException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		}
	}
	public MoveThread(Vehicle vehicle, Dimension newSize, RoadPanel roadPanel) {
		super();
		this.vehicle= vehicle;
		this.rp =roadPanel;
		this.newSize = newSize;
	}

}
