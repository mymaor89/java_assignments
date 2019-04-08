package vehicles;

/**
 * Class define benzene engine specifications
 * 
 * @author
 *
 */
public class BenzineEngine extends Engine {
	private final static int LITER_PER_KM  = 2;

	/**
	 * 
	 * @param fuelTankCapacityOfEngine fuel capacity of engine 
	 */
	public BenzineEngine(double fuelTankCapacityOfEngine) {
		super(LITER_PER_KM, fuelTankCapacityOfEngine);

	}

	@Override
	/**
	 * Override function to string representation of variables
	 */
	public String toString() {
		return super.toString() + "type: " + "Benzine\n";
	}

}
