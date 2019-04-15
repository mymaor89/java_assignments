package vehicles;

import java.nio.channels.NotYetConnectedException;

import graphics.IAnimal;
import graphics.IClonable;

public class PackAnimal implements IAnimal, IClonable {
	private static final int MAX_ENERGY = 1000;
	private static final int ENERGY_REDUCED_PER_KM = 20;
	private String animal;
	private int energyLevel;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new PackAnimal(animal,energyLevel);
	}

	public PackAnimal(String animal, int energyLevel) {
		super();
		this.animal = animal;
		this.energyLevel = energyLevel;
	}

	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFuelConsumption() {
		return ENERGY_REDUCED_PER_KM;
	}

	@Override
	public void move(Point p) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public String getAnimalName() {
		return animal;
	}

	@Override
	public boolean eat() {
		this.energyLevel = MAX_ENERGY;
		return true;
	}

}
