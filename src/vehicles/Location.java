package vehicles;

import java.util.InputMismatchException;

/**
 * class is handling the location of the vehicle
 * 
 * @author Ana
 *
 */
enum Orientation {
	NORTH, WEST, EAST, SOUTH;
}

public class Location {
	private Point point;
	private String orientation;

	public Location() {

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
				this.orientation = d.toUpperCase();
		} catch (Exception e) {
			throw new InputMismatchException();
		}
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
		return orientation;
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
}
