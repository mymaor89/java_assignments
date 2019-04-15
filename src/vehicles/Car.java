package vehicles;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import graphics.RoadPanel;

/**
 * Car representation
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */

public class Car extends HasEngine {
	private int numOfPassengers;
	private final static int WHEELS = 4;
	private final static int FUEL_TANK_CAPACITY = 40;
	private final static int SPEED = 4;
	

	/**
	 * cars constructor
	 * 
	 * @param numOfPassengers    number of seats in car
	 * @param currentFuelCapcity current amount of fuel in fuel tank
	 */
	/*
	public Car(int id, String color, Location location, double kilometer, boolean lights, EngineType engineType,
			int minimumAge, int numOfPassengers, double currentFuelCapcity, BackgroundPanel backgroundPanel) {
		super(id, color, WHEELS, location, kilometer, lights, buildEngine(engineType), minimumAge, currentFuelCapcity,
				SPEED, backgroundPanel);
		this.numOfPassengers = numOfPassengers;
		try {

			this.img1 = ImageIO.read(new File("./images/greenBikeEast.png"));
			this.img2 = ImageIO.read(new File("./images/greenBikeEast.png"));
			this.img3 = ImageIO.read(new File("./images/greenBikeEast.png"));
			this.img4 = ImageIO.read(new File("./images/greenBikeEast.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Car(int id, String color, Location location, double kilometer, boolean lights, EngineType engineType,
			int minimumAge, int numOfPassengers, double currentFuelCapacity) {
		super(id, color, WHEELS, location, kilometer, lights, buildEngine(engineType), minimumAge, currentFuelCapacity);
		this.numOfPassengers = numOfPassengers;

	}
*/
	public Car(String color, EngineType type,RoadPanel roadPanel) {
		super(color,WHEELS,buildEngine(type),SPEED,roadPanel);
		this.numOfPassengers = numOfPassengers;

	}

	private static Engine buildEngine(EngineType type) {
		if (type == EngineType.BENZINE) {
			return new BenzineEngine(FUEL_TANK_CAPACITY);
		} else {
			return new SolarEngine(FUEL_TANK_CAPACITY);
		}
	}

	@Override
	/**
	 * Override function to string representation of variables
	 */
	public String toString() {
		return "Car@\n" + super.toString() + "Passengers: " + numOfPassengers;
	}

	public int getSpeed() {
		return SPEED;
	}

	@Override
	/**
	 * Override for exist function in fathers class but with different
	 * implementation
	 */
	public boolean drive(Point dest) {
		double fuelTodestenation = getLocation().distance(dest) * getFuelConsumptionPerKM();
		if (fuelTodestenation >= getEngine().getFuelTankCapacityOfEngine()) {
			System.out.println("Location not changed\nFuel tank too small for journey");
			return false;
		}
		if (fuelTodestenation <= getCurrentFuelCapcity()) {
			setCurrentFuelCapcity(getCurrentFuelCapcity() - fuelTodestenation);
			return super.drive(dest);
		} else
			System.out.println("location didn't change, not enoght fuel\n" + "Do you wont to refuel? 1:yes, 2:no");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		sc.close();
		if (choose == 1) {
			refuel();
			return drive(dest);
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param dest destination Point
	 * @return distance in Manhattan geometry
	 */
	protected int getDistance(Point dest) {
		return getLocation().distance(dest);
	}

	/*
	 * @Override public void drawObject(Graphics g) { if (orien ==
	 * Orientation.NORTH) // car drives to the north side g.drawImage(img1,
	 * getLocation().getPoint().getX() - size / 2, getLocation().getPoint().getY() -
	 * size / 10, size, size * 2, pan); else if (orien == Orientation.SOUTH) // car
	 * drives to the south side g.drawImage(img2, getLocation().getPoint().getX(),
	 * getLocation().getPoint().getY() - size / 10, size, size, pan); else if (orien
	 * == Orientation.EAST) // car drives to the east side g.drawImage(img3,
	 * getLocation().getPoint().getX(), getLocation().getPoint().getY() - size / 10,
	 * size * 2, size, pan); else if (orien == Orientation.WEST) // car drives to
	 * the west side g.drawImage(img4, getLocation().getPoint().getX(),
	 * getLocation().getPoint().getY() - size / 10, size * 2, size, pan); }
	 */
	@Override
	public String getVehicleName() {
		return "Car";
	}

}
