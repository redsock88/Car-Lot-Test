package com.qfree.cartest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.qfree.cartest.components.BaseComponentImpl;
import com.qfree.cartest.components.IComponent;
import com.qfree.cartest.models.BaseCarImpl;
import com.qfree.cartest.models.ICar;


public class CarTest{
	
	private final List<ICar> carLot;
	
	//seed variables and values
	private ICar car1 = new BaseCarImpl("Jaguar","XK","2016");
	private ICar car2 = new BaseCarImpl("Jeep","Cherokee","2015");
	private ICar car3 = new BaseCarImpl("Ford","F150","2015");
	private ICar car4 = new BaseCarImpl("Jaguar","F-Type","2017");
	
	
	CarTest() {
		carLot = new ArrayList<>();
	}
	
	public static void main(String args[]) {
		System.out.println("App started!");
		
		CarTest carTest = new CarTest();
		/**
		 * Step 1:
		 * 
		 * Create two(2) or more car implementations and add those
		 * cars to the car lot.  After building out the lot, print the inventory
		 * of the lot utilizing Java 8 streams to include all relevant attributes 
		 * of the vehicles (make/model/year).  At least 1 of the new cars must 
		 * be model year 2016 or later
		 */
		carTest.buildCarLot();
		carTest.printLotInventory();
		
		
		/**
		 * Step 2:
		 * 
		 * Create a filter predicate to only print out new cars and print those cars
		 */
		carTest.printNewCars((ICar c) -> Integer.parseInt(c.getCarYear()) >= 2016 );
		
		/**
		 * Step 3:
		 * 
		 * - Create Engine / Headlights / Stereo components
		 * - Modify the vehicle creation to pass in instances of each component for each car 
		 * - Finish building out the turn-on/turn-off function to send a command to each component and 
		 * 	 print out a message indicating each component has turned on or off 
		 * 		e.x. "Engine has started"
		 * - Make sure to add error and exception handling if attempting to start a vehicle that's
		 *   already started or stop one that's already stopped.
		 * - Invoke the turn on and turn off method for each car in the lot, printing all
		 *   status to the console
		 */	
		for(int i = 0; i < carTest.carLot.size(); i++){
			IComponent component1 = new BaseComponentImpl("Engine");
			IComponent component2 = new BaseComponentImpl("Headlights");
			IComponent component3 = new BaseComponentImpl("Stereo");
			List<IComponent> components = new ArrayList<IComponent>();
			components.add(component1);
			components.add(component2);
			components.add(component3);
			carTest.carLot.get(i).setComponents(components);
		}
		carTest.startAllCars();
		carTest.stopAllCars();
		
	}
	
	void buildCarLot() {
		carLot.add(car1);
		carLot.add(car2);
		carLot.add(car3);
		carLot.add(car4);
	}
	
	void printLotInventory() {
		System.out.println("Printing Lot Inventory");
		for(int i = 0; i < carLot.size(); i++){
			int lotSpaceNumber = i + 1;
			System.out.println("Lot Space #"+lotSpaceNumber+": "+carLot.get(i).getCarMake()+" / "+carLot.get(i).getCarModel()+" / "+carLot.get(i).getCarYear());
		}
	}
	
	void printNewCars(Predicate<ICar> predicate) {
		System.out.println("Printing Filtered Lot Inventory");
		for(int i = 0; i < carLot.size(); i++){
			if(predicate.test(carLot.get(i))){
				int lotSpaceNumber = i + 1;
				System.out.println("Lot Space #"+lotSpaceNumber+": "+carLot.get(i).getCarMake()+" / "+carLot.get(i).getCarModel()+" / "+carLot.get(i).getCarYear());
			}
		}
	}
	
	void startAllCars() {
		for(int i = 0; i < carLot.size(); i++){
			carLot.get(i).start();
		}
	}
	
	void stopAllCars() {
		for(int i = 0; i < carLot.size(); i++){
			carLot.get(i).turnOff();
		}
	}
}
