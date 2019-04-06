package vehicles;

import graphics.IClonable;

/**
 * Class define point
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */
public class Point implements IClonable{
	private int x;
	private int y;

	/**
	 * 
	 * @param x x coordinate of point
	 * @param y y coordinate of point
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	protected int getX() {
		return this.x;
	}

	protected int getY() {
		return this.y;
	}

	/**
	 * calculates distance between two points in Manhattan geometry
	 * 
	 * @param other second point
	 * @return the distance between this point to the other in Manhattan geometry
	 */
	public int distance(Point other) {
		return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
	}

	@Override
	/**
	 * overloading to exist fun equal, by class's own implementation
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p2 = (Point) obj;
			return x == p2.x && y == p2.y;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * String representation of point
	 */
	public String toString() {
		return "Point is:(" + x + "," + y + ")";
	}

}
