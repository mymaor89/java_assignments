package vehicles;

/**
 * class extend vehicle with it's special veriables
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */
public class Carriage extends Vehicle {
	private String animal;
	private final static int SPEED = 1;

	/**
	 * @param animal which animal carry carriage
	 */
	public Carriage(int id, String color, Location location, double kilometer, boolean lights, String animal) {
		super(id, color, 4, location, kilometer, lights);
		this.animal = animal;
	}

	@Override
	/**
	 * string representation
	 */
	public String toString() {
		return "Carriage@\n" + super.toString() + "animal: " + animal + "\n";
	}

}
