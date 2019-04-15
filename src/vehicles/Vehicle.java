package vehicles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.imageio.ImageIO;
import graphics.CityPanel;
import graphics.IClonable;
import graphics.IDrawable;
import graphics.IMoveable;
import graphics.RoadPanel;

/**
 * an abstract class is a basis for all vehicles
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 *
 */


public abstract class Vehicle implements IMoveable, IDrawable, IClonable {
	
	private final static String[] types = {"solar car",
			"benzine car", "bike","carriage"};
	
	final static int CAR_SEATS = 5;
	final static int BIKE_SEATS = 1;
	final static int CARRIAGE_SEATS = 2;
	final static int FUEL = 0 ; 
	public static int idOfVehicles = 1000;
	
	
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
	protected int speed;
	/**** ADDED Phase II *********/
	protected RoadPanel pan;
	protected BufferedImage img1, img2, img3, img4;
	private final static int MINIMAL_AGE = 18;
	
	
	
	public void setLoc(Location loc) {
		this.loc = loc;
	}

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
		return color;
	}

	@Override
	public String getVehicleName() {
		return "Vehicle";
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getFuelConsumption() {
		return fuelConsumption;
	}

	@Override
	public boolean move(Point p) {
		return false;
	}




	
	public BufferedImage getImg1() {
		return img1;
	}

	public BufferedImage getImg2() {
		return img2;
	}
	public BufferedImage getImg3() {
		return img3;
	}

	public BufferedImage getImg4() {
		return img4;
	}
	protected int size;

	/**
	 * Constructor
	 * 
	 * @param numOfWheels number of wheels of vehicle
	 * @param id          identifier of vehicle
	 * @param color       of vehicle
	 * @param location    current location of vehicle
	 * @param kilometer   total mileage of vehicle
	 * @param lights      if they on or off
	 */
	/*
	public Vehicle(int id, String color, int numOfWheels, Location location,
			double kilometer, boolean lights,
			CityPanel pan, int size,BackgroundPanel backgroundPanel) {
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
		this.pan = backgroundPanel;
		this.size = size;

	}*/

	public Vehicle( String color, int numOfWheels,int speed, RoadPanel roadPanel) {
		id = idOfVehicles++;
		try {
			Color c = Color.valueOf(color.toUpperCase());
			if (c != null)
				this.color = color.toUpperCase();
		} catch (Exception e) {
			throw new InputMismatchException();
		}

		this.numOfWheels = numOfWheels;
		this.loc = new Location(new Point(0, 0), Orientation.EAST);
		this.kilometer = 0;
		this.lights = false;
		this.pan = roadPanel;
		this.speed = speed;
		String path = "images//"+ color.toLowerCase()+getVehicleName();
		try {
			System.out.println(path+"East.png");
			this.img1 = ImageIO.read(new File(path+"North.png"));//north
			this.img2 = ImageIO.read(new File(path+"South.png"));//south
			this.img3 = ImageIO.read(new File(path+"East.png"));//east
			this.img4 = ImageIO.read(new File(path+"West.png"));//west

		} catch (IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	public Vehicle(int id, String color, int numOfWheels, Location location, 
			double kilometer, boolean lights) {
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
*/
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
	public Location getLocation() {
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

	public void setLocation(Location location) {
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
	public Orientation getOrien() {
		return orien;
	}

}
