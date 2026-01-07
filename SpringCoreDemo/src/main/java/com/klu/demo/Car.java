package com.klu.demo;

public class Car {
	private Engine engine;
	public Car(Engine engine) {   // constructor dependency injection
		this.engine=engine;
	}
	public void drive() {
		engine.start();
		System.out.println("Car is moving...");
	}
}
