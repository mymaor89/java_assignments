package vehicles;

/**
 * Class giving information regarding fueling and vehicles that have engine
 * 
 * @author
 *
 */
public abstract class HasEngine extends Vehicle {
	private Engine engine;
	private double currentFuelCapcity;

	protected Engine getEngine() {
		return engine;
	}

	protected int getMinimumAge() {
		return minimumAge;
	}

	private int minimumAge;

	/**
	 * Constractor
	 * 
	 * @param                    id= license num
	 * @param color
	 * @param numOfWheels
	 * @param                    location= current location
	 * @param                    kilometer= mileage
	 * @param                    lights= check if light on or off
	 * @param                    engine= engine object
	 * @param minimumAge
	 * @param currentFuelCapcity
	 */
	public HasEngine(int id, String color, int numOfWheels, Location location, double kilometer, boolean lights,
			Engine engine, int minimumAge, double currentFuelCapcity) {
		super(id, color, numOfWheels, location, kilometer, lights);
		this.engine = engine;
		this.minimumAge = minimumAge;
		this.currentFuelCapcity = currentFuelCapcity;
	}

	@Override
	/**
	 * Override function to string representation of variables
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n").append(engine.toString()).append("minimum age: " + minimumAge)
				.append("\ncurrent amount of gas: " + currentFuelCapcity + "\n");
		return sb.toString();
	}

	/**
	 * get function
	 * 
	 * @return the value of fuel consumption variable
	 */
	protected double getFuelConsumptionPerKM() {
		return engine.getFuelConsumptionPerKM();
	}

	/**
	 * boolean function that refuel the vehicle if it's engine is not full
	 * 
	 * @return true if the car refueled and false if it already full
	 */
	public boolean refuel() {
		if (getCurrentFuelCapcity() == engine.getFuelTankCapacityOfEngine()) {
			return false;
		} else {
			setCurrentFuelCapcity(engine.getFuelTankCapacityOfEngine());
			return true;
		}
	}

	/**
	 * get function
	 * 
	 * @return the value of fuel capcity variable
	 */
	protected double getCurrentFuelCapcity() {
		return currentFuelCapcity;
	}

	/**
	 * set function
	 * 
	 * @return set the fuel capcity
	 */
	protected void setCurrentFuelCapcity(double currentFuelCapcity) {
		this.currentFuelCapcity = currentFuelCapcity;
	}

}
