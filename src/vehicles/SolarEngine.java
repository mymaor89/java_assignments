package vehicles;

/**
 * Class define solar engine specifications
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 *
 */

public class SolarEngine extends Engine {
	private final static int LITER_PER_KM  = 6;

	/**
	 * 
	 * @param fuelTankCapacityOfEngine fuel capacity of engine 
	 */
	public SolarEngine(double fuelTankCapacityOfEngine) {
		super(LITER_PER_KM, fuelTankCapacityOfEngine);
	}

	@Override
	/**
	 * string representation
	 */
	public String toString() {
		return super.toString() + "type: " + "Solar\n";
	}

}
