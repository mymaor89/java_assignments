package vehicles;

import java.util.Scanner;

/**
 * Car representation
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */

public class Car extends HasEngine {
	private int numOfPassengers;
	private final static int WHEELS = 4;
	private final static int FUEL_TANK_CAPACITY = 40;

	/**
	 * cars constructor
	 * 
	 * @param numOfPassengers    number of seats in car
	 * @param currentFuelCapcity current amount of fuel in fuel tank
	 */
	public Car(int id, String color, Location location, double kilometer, boolean lights, EngineType engineType,
			int minimumAge, int numOfPassengers, double currentFuelCapcity) {
		super(id, color, WHEELS, location, kilometer, lights, buildEngine(engineType), minimumAge, currentFuelCapcity);
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
	 * @return	distance in Manhattan geometry 
	 */
	protected int getDistance(Point dest) {
		return getLocation().distance(dest);
	}
}
