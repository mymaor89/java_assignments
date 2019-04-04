package vehicles;

/**
 * Bike representation
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */

public class Bike extends Vehicle {
	private int numOfGears;
	private final static int SPEED = 2;
	private final static int WHEELS = 2;
	/**
	 * Constructor
	 * @param numOfGears number of gears
	 */
	public Bike(int id, String color, Location location, double kilometer, boolean lights, int numOfGears) {
		super(id, color, WHEELS, location, kilometer, lights);
		this.numOfGears = numOfGears;
	}

	@Override
	/**
	 * string representation
	 */
	public String toString() {
		return "Bike@\n" + super.toString() + "\n#gears: " + numOfGears + "\n";
	}

}
