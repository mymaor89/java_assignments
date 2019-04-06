package vehicles;

/**
 * Class define engine specifications
 * 
 * @author
 * Maor Yatskan 301791380
 * Anna Rogozin 323686477
 */

public abstract class Engine {
	private double fuelConsumptionPerKM;
	private double fuelTankCapacityOfEngine;

	/**
	 * Constructor
	 * 
	 * @param fuelConsumptionPerKM     -fuel consumption
	 * @param fuelTankCapacityOfEngine - tank capacity
	 */
	public Engine(double fuelConsumptionPerKM) {
		this.fuelConsumptionPerKM = fuelConsumptionPerKM;
	}

	public Engine(double fuelConsumptionPerKM, double fuelTankCapacityOfEngine) {
		this.fuelConsumptionPerKM = fuelConsumptionPerKM;
		this.fuelTankCapacityOfEngine = fuelTankCapacityOfEngine;
	}

	/**
	 * get function
	 * 
	 * @return value of fuel consumption variable
	 */
	protected double getFuelConsumptionPerKM() {
		return fuelConsumptionPerKM;
	}

	/**
	 * get function
	 * 
	 * @return the value of fuel tank capacity variable
	 */
	protected void setfuelTankCapacityOfEngine(double f) {
		this.fuelTankCapacityOfEngine = f;

	}

	public double getFuelTankCapacityOfEngine() {
		return fuelTankCapacityOfEngine;
	}

	@Override
	/**
	 * Override function to string representation of variables
	 */
	public String toString() {
		return "fuelConsumptionPerKM: " + fuelConsumptionPerKM + "\n" + "fuelTankCapacityOfEngine: "
				+ fuelTankCapacityOfEngine + "\n";
	}

}