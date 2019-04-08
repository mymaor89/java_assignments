package vehicles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.InputMismatchException;

import graphics.CityPanel;
import graphics.IClonable;
import graphics.IDrawable;
import graphics.IMoveable;

/**
 * an abstract class is a basis for all vehicles
 * 
* @author Maor Yatskan 301791380 Anna Rogozin 323686477
 *
 */
enum Color {
	RED, SILVER, GREEN, WHITE;
}

public abstract class Vehicle implements IMoveable, IDrawable, IClonable {
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getFuelConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean move(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	private int id;
	private String color;
	private int numOfWheels;
	private double kilometer;
	protected Boolean lights;
	protected Color col;
	protected int wheels;
	protected Location loc;
	protected Orientation orien;
	protected int fuelConsumption;
	/****ADDED Phase II*********/
	protected CityPanel pan;
	protected BufferedImage img1, img2, img3, img4;
	protected int size;
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
	public Vehicle(int id, String color, int numOfWheels, Location location, double kilometer, boolean lights,
			CityPanel pan,BufferedImage[] imgs, int size) {
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
		this.loc = location;
		this.kilometer = kilometer;
		this.lights = lights;
		this.img1 = imgs[0];
		this.img2 = imgs[1];
		this.img3 = imgs[2];
		this.img4 = imgs[3];
		this.pan = pan;
		this.size = size;
		
		
	}
	
	
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
		this.loc = location;
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
		return loc;
	}

	protected Point getPoint() {
		return loc.getPoint();
	}

	/**
	 * 
	 * @return object's ID
	 */
	public int getID() {
		return id;
	}

	protected void setLocation(Location location) {
		this.loc = location;
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
