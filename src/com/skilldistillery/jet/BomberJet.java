package com.skilldistillery.jet;

public class BomberJet extends Jet implements CargoCarrier, CombatReady, Discharges {

	public BomberJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void releaseCargo() {
		System.out.println("The " + this.getModel() + " prepares to drop its payload on the target...");

	}

	@Override
	public void fight() {
		System.out.println("\nThe " + this.getModel() + " engages in defensive maneuvers...");

	}

	@Override
	public void loadCargo() {
		System.out.println("\nThe " + this.getModel() + " begins loading its munitions for deployment...");

	}

	@Override
	public void fly() {
		System.out.println(this.toString());
		double flightTime = this.getRange() / ((double)this.getSpeed());
		System.out.printf("This bomber flies for %.2f hours.%n",flightTime);
	}
}
