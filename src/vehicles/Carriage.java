package vehicles;

import javax.swing.JPanel;
import graphics.RoadPanel;

/**
 * class extend vehicle with it's special veriables
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */
public class Carriage extends Vehicle {
	private PackAnimal animal;
	private final static int SPEED = 1;
	private static final int WHEELS = 4;
	/**
	 * @param animal which animal carry carriage
	 */
	public Carriage(String color,PackAnimal animal,RoadPanel pan) {
		super(color, WHEELS,SPEED, pan);
		this.animal = animal;
	}
	/*
	public Carriage(int id, String color, Location location, double kilometer, boolean lights, PackAnimal animal) {
		super(id, color, 4, location, kilometer, lights);
		this.animal = animal;
	}*/
	@Override
	public String getVehicleName() {
		return "Carriage";
	}

	@Override
	/**
	 * string representation
	 */
	public String toString() {
		return "Carriage@\n" + super.toString() + "animal: " + animal.toString() + "\n";
	}

}
