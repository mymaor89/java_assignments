package vehicles;

import java.util.InputMismatchException;

/**
 * an abstract class is a basis for all vehicles
 * 
* @author Maor Yatskan 301791380 Anna Rogozin 323686477
 *
 */
enum Color {
	RED, SILVER, GREEN, WHITE;
}

public abstract class Vehicle {
	private int id;
	private String color;
	private int numOfWheels;
	private Location location;
	private double kilometer;
	private boolean lights;

	/**
	 * Constructor
	 * 
	 * @param numOfWheels number of wheels of vehicle
	 * @param id identifier of vehicle
	 * @param color of vehicle
	 * @param location current location of vehicle
	 * @param kilometer total mileage of vehicle
	 * @param lights if they on or off
	 */
	public Vehicle(int id, String color, int numOfWheels, Location location, double kilometer, boolean lights) {
		if (id >= 1000 && id <= 1000000)
			this.id = id;
		else {
			throw new InputMismatchException();
		}
		try {
			Color c = Color.valueOf(color.toUpperCase());
			if (c != null)
				this.color = color.toUpperCase();
		} catch (Exception e) {
			throw new InputMismatchException();
		}

		this.numOfWheels = numOfWheels;
		this.location = location;
		this.kilometer = kilometer;
		this.lights = lights;

	}

	@Override
	/**
	 * Overriding of string representation of the variables
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + id + "\n").append("Color: " + color + "\n").append("number of wheels: " + numOfWheels + "\n")
				.append("Location: " + getLocation().toString()).append("kilometer: " + kilometer + "\n")
				.append("lights are " + (lights ? "on" : "off ") + "\n");
		return sb.toString();

	}

	/**
	 * 
	 * @return object's location
	 */
	protected Location getLocation() {
		return location;
	}

	protected Point getPoint() {
		return location.getPoint();
	}

	/**
	 * 
	 * @return object's ID
	 */
	public int getID() {
		return id;
	}

	protected void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * 
	 * @param p Point of destination
	 * @return true if successfully arrived to destination
	 */
	public boolean drive(Point p) {
		kilometer += getLocation().distance(p);
		this.setLocation(new Location(p, getLocation().getOrientation()));
		return true;
	}

}
