package System;

import java.util.InputMismatchException;

import vehicles.*;
import java.util.Scanner;

/**
 * Class that demonstrate the system features
 * 
 * @author Maor Yatskan 301791380 Anna Rogozin 323686477
 */
public class MySystem {
	private static Border border;
	private static Vehicle[] v_arr;
	private static Scanner sc;

	/**
	 * main function runs the code
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		try {
			initBorder();
			choseAmountOfVehicle();
			initArray();
			printAll();
			while (true) {
				int workingVehicle = chooseWorkingVehicle();
				if (workingVehicle == -1) {
					exitSafely();
				}
				printWorkingVehicle(workingVehicle);
				Point dest = scanPoint();
				v_arr[workingVehicle].drive(dest);
				printWorkingVehicle(workingVehicle);
			}
		} catch (InputMismatchException e) {
			exitSafely();
		}
	}

	/**
	 * function use build in class of border and get the border from user
	 * 
	 * @return true if borders is not negative
	 */
	private static boolean initBorder() {
		int minX, minY, maxX, maxY;
		System.out.println("Type minimum x, y and maximum x,y");
		minX = sc.nextInt();
		minY = sc.nextInt();
		maxX = sc.nextInt();
		maxY = sc.nextInt();
		border = new Border(minX, minY, maxX, maxY);
		return true;
	}

	/**
	 * Gets point from user
	 * 
	 * @return point object
	 */
	private static Point scanPoint() {
		System.out.println("Enter x of destenation: ");
		int x = sc.nextInt();
		System.out.println("Enter y of destenation: ");
		int y = sc.nextInt();
		return new Point(x, y);

	}

	private static void printWorkingVehicle(int workingVehicle) {
		System.out.println(v_arr[workingVehicle].toString());

	}

	/**
	 * function ask user to choose vehicle to work with
	 * 
	 * @return asked vehicle
	 */
	private static int chooseWorkingVehicle() {
		System.out.println("Choose working vehicle from 1 to " + v_arr.length);
		int working = sc.nextInt();
		working--;
		if (working >= 0 && working < v_arr.length) {
			return working;
		} else
			return -1;

	}

	private static boolean printAll() {
		for (int i = 0; i < v_arr.length; i++) {
			System.out.println(v_arr[i].toString());
		}
		return true;
	}

	/**
	 * func initialize vehicles
	 * 
	 * @return true if succcsessfully
	 */
	private static boolean initArray() {
		for (int i = 0; i < v_arr.length; i++) {
			initVehicle(i);
		}
		return true;

	}

	/**
	 * function ask user for amount of vehicles do build
	 * 
	 * @return true if function succeeded
	 */
	private static boolean choseAmountOfVehicle() {
		System.out.println("How many vehicles? ");
		int array_size = sc.nextInt();
		v_arr = new Vehicle[array_size];
		return true;

	}

	/**
	 * function ask user for which vehicle to build
	 * 
	 * @return true if function succeeded
	 */
	private static boolean initVehicle(int i) {
		System.out.println("motored vehicle? 1:yes 2:no");
		int choose = sc.nextInt();
		if (choose == 1) {
			v_arr[i] = initCar();
		} else {
			System.out.println("Bike - 1\n" + "Carriage -2 \n");
			choose = sc.nextInt();
			if (choose == 1)
				v_arr[i] = initBike();
			else
				v_arr[i] = initCarriage();
		}
		return true;
	}

	/**
	 * function check input if wrong ,exit
	 *
	 */
	private static void exitSafely() {
		System.out.println("Wrong input exiting application...");
		System.exit(0);

	}

	/**
	 * func initialize carriage vehicle
	 * 
	 * @return carriage obj
	 */
	private static Carriage initCarriage() {
		int id;
		Location location;
		double kilometer;
		boolean lights;
		String animal;
		System.out.println("Type ID in range 10^3-10^6:");
		id = sc.nextInt();
		System.out.println("Type color one of the following:RED, GREEN, WHITE, SILVER ");
		String c = sc.next();
		System.out.println("Enter x of location");
		int x = sc.nextInt();
		System.out.println("Enter y of location");
		int y = sc.nextInt();
		System.out.println("Type Orientation one of the folowwing:NORTH,WEST,EAST,SOUTH");
		String o = sc.next();
		location = new Location(new Point(x, y), o);
		System.out.println("Enter Kilometrage of carriage");
		kilometer = sc.nextDouble();
		System.out.println("Are lights on? 1:Yes 2:No");
		lights = sc.nextInt() == 1;
		System.out.println("Type animal of carriage: ");
		animal = sc.next();
		return new Carriage(id, c, location, kilometer, lights, animal);
	}

	/**
	 * func initialize bike vehicle
	 * 
	 * @return bike obj
	 */
	private static Bike initBike() {
		int id;
		Location location;
		double kilometer;
		boolean lights;
		int numOfGears;
		System.out.println("Type ID in range 10^3-10^6: ");
		id = sc.nextInt();
		System.out.println("Type color one of the following:RED, GREEN, WHITE, SILVER ");
		String c = sc.next();
		System.out.println("Enter x of location");
		int x = sc.nextInt();
		System.out.println("Enter y of location");
		int y = sc.nextInt();
		System.out.println("Type Orientation one of the following: NORTH,WEST,EAST,SOUTH");
		String o = sc.next();
		location = new Location(new Point(x, y), o);
		System.out.println("Enter Kilometrage of Bike");
		kilometer = sc.nextDouble();
		System.out.println("Are lights on? 1:Yes 2:No");
		lights = sc.nextInt() == 1;
		System.out.println("Type number of gears: ");
		numOfGears = sc.nextInt();
		return new Bike(id, c, location, kilometer, lights, numOfGears);
	}

	/**
	 * func initialize car vehicle
	 * 
	 * @return car obj
	 */
	private static Car initCar() {
		int id;
		Location location;
		double kilometer;
		boolean lights;
		int minimumAge;
		int numOfPassengers;
		System.out.println("Type ID in range 10^3-10^6: ");
		id = sc.nextInt();
		System.out.println("Type color one of the following: RED, GREEN, WHITE, SILVER ");
		String c = sc.next();
		System.out.println("Enter How much fuel in the gas tank");
		double currentFuelCapacity = sc.nextDouble();
		System.out.println("Enter x of location");
		int x = sc.nextInt();
		System.out.println("Enter y of location");
		int y = sc.nextInt();
		System.out.println("Type Orientation one of the following: NORTH,WEST,EAST,SOUTH");
		String o = sc.next();
		location = new Location(new Point(x, y), o);
		System.out.println("Enter Kilometrage of car");
		kilometer = sc.nextDouble();
		System.out.println("Are lights on? 1:Yes 2:No");
		lights = sc.nextInt() == 1;
		System.out.println("Enter minimum age");
		minimumAge = sc.nextInt();
		System.out.println("How many seats?");
		numOfPassengers = sc.nextInt();
		System.out.println("Choose engine 1:Benzine 2:Solar");
		int engineType = sc.nextInt();

		return new Car(id, c, location, kilometer, lights, EngineType.fromInteger(engineType), minimumAge,
				numOfPassengers, currentFuelCapacity);
	}

	/**
	 * function check in point is on borders if yes so it activate drive func
	 * 
	 * @param id=car num
	 * @param destenation=the point of distenation
	 * @return true if succeeded
	 */

	@SuppressWarnings("unused")
	private boolean drive(int id, Point destenation) {
		Vehicle v = getVehicle(id);
		return border.inBounds(destenation) && v.drive(destenation);

	}

	private Vehicle getVehicle(int id) {
		for (int i = 0; i < v_arr.length; i++) {
			if (v_arr[i].getID() == id) {
				return v_arr[i];
			}
		}
		return null;
	}

}
