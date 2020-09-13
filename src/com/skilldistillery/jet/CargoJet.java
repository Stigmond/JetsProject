package com.skilldistillery.jet;

public class CargoJet extends Jet implements CargoCarrier {

	CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("\nThe " + this.getModel() + " takes in its cargo...");
	}

	@Override
	public void fly() {
		System.out.println(this.toString());
		double flightTime = this.getRange() / ((double)this.getSpeed());
		System.out.printf("This cargo jet flies for %.2f hours.%n", flightTime);
	}
}
