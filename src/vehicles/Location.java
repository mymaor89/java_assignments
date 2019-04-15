package vehicles;

import java.util.InputMismatchException;

/**
 * class is handling the location of the vehicle
 * 
 * @author Ana
 *
 */

public class Location {
	private Point point;
	private Orientation orientation;

	public Location() {

	}
	public void setX(int x) {
		this.point.setX(x);
	}

	public void setY(int y) {
		this.point.setY(y);
	}
	/**
	 * Constractor create an instance
	 * 
	 * @param p point location
	 * @param   d= direction one of enum parameters
	 */
	public Location(Point p, String d) {
		this.point = p;
		try {
			Orientation o = Orientation.valueOf(d.toUpperCase());
			if (o != null)
				this.orientation = o;
		} catch (Exception e) {
			throw new InputMismatchException();
		}
	}

	public Location(Point point, Orientation orien) {
		this.point = point;
		this.orientation = orien;
	}

	/**
	 * Calculate the distance according to Manheten forula
	 * 
	 * @param p= second point to calculate the distance
	 * @return calculated distance
	 */
	public int distance(Point p) {
		return point.distance(p);
	}

	protected String getOrientation() {
		return orientation.toString();
	}
	
	protected Point getPoint() {
		return point;
	}

	@Override
	/**
	 * Override function to string representation of variables
	 */
	public String toString() {
		return "[point=" + point.toString() + ", orientation=" + orientation + "]\n";
	}
	public int getX() {
		// TODO Auto-generated method stub
		return point.getX();
	}
	public int getY() {
		return point.getY();
	}
}
