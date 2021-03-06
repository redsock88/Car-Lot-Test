package com.qfree.cartest.components;

public abstract class BaseComponent implements IComponent {

	private boolean started = false;
	
	protected void start() {
		started = true;
	}
	
	protected void stop() {
		started = false;
	}
	
	public boolean isStarted() {
		return started;
	}
	
}
