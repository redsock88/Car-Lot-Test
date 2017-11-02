package com.qfree.cartest.components;

import com.qfree.cartest.actions.CarCommands;

public class BaseComponentImpl extends BaseComponent {

	String componentType = null;

	public BaseComponentImpl(String type) {
		componentType = type;
	}
	
	@Override
	public void accept(CarCommands command) {
		if(command.equals(command.TURN_ON) && !super.isStarted()){
			super.start();
			System.out.println(componentType+" has started.");
		}
		if(command.equals(command.TURN_OFF) && super.isStarted()){
			super.stop();
			System.out.println(componentType+" has stopped.");
		}
	}
	
	@Override
	public boolean isStarted(){
		return super.isStarted();
	}
	
}
