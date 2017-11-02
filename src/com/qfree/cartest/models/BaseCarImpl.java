package com.qfree.cartest.models;

public class BaseCarImpl extends BaseCar {
	
	String carMake = null;
	String carModel = null;
	String carYear = null;
	
	public BaseCarImpl(String make, String model, String year) {
		carMake = make;
		carModel = model;
		carYear = year;
	}

	@Override
	public String getCarMake() {
		return carMake;
	}

	@Override
	public String getCarModel() {
		return carModel;
	}

	@Override
	public String getCarYear() {
		return carYear;
	}
}
