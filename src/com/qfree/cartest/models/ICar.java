package com.qfree.cartest.models;

import java.util.List;

import com.qfree.cartest.actions.CarActions;
import com.qfree.cartest.components.IComponent;

public interface ICar extends CarActions {

	/**
	 * @return the make of the car
	 */
	String getCarMake();
	
	/**
	 * @return the model of the car
	 */
	String getCarModel();
	
	/**
	 * @return the year the car was manufactured
	 */
	String getCarYear();

	/**
	 * sets the components for that car
	 */
	void setComponents(List<IComponent> components);
	
	/**
	 * @return the components equiped on the car
	 */
	List<IComponent> getComponents();
	
}
