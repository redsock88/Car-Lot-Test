package com.qfree.cartest.models;

import java.util.ArrayList;
import java.util.List;

import com.qfree.cartest.actions.CarCommands;
import com.qfree.cartest.components.IComponent;

public abstract class BaseCar implements ICar {

	private List<IComponent> components = new ArrayList<>();
	
	@Override
	public void setComponents(List<IComponent> components){
		this.components = components;
	}
	
	@Override
	public List<IComponent> getComponents(){
		return components;
	}
	
	@Override
	public boolean start() {
		int count = 0;
		for(int i = 0; i < components.size(); i++){
			if(!components.get(i).isStarted()){
				components.get(i).accept(CarCommands.TURN_ON);
			}else{
				count++;
			}
		}
		if(count == components.size()){
			System.out.println("Car already started.");
			return true;
		}else{
			System.out.println("Started car");
			return true;
		}
	}

	@Override
	public boolean turnOff() {
		int count = 0;
		for(int i = 0; i < components.size(); i++){
			if(components.get(i).isStarted()){
				components.get(i).accept(CarCommands.TURN_OFF);
			}else{
				count++;
			}
		}
		if(count == components.size()){
			System.out.println("Car already turned off.");
			return true;
		}else{
			System.out.println("Stopped car");
			return true;
		}
	}

}
