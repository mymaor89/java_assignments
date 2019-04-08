package vehicles;

import graphics.IAnimal;
import graphics.IClonable;

public class PackAnimal implements IAnimal, IClonable {
	private static final int MAX_ENERGY = 1000;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean move(Point p) {
		// TODO Auto-generated method stub
			return false;
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
