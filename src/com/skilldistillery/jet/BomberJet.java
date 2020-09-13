package com.skilldistillery.jet;

public class BomberJet extends Jet implements CargoCarrier, CombatReady, Discharges {

	BomberJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void releaseCargo() {
		System.out.println("This bomber prepares to drop its payload on the target...");

	}

	@Override
	public void fight() {
		System.out.println("This bomber engages in defensive maneuvers...");

	}

	@Override
	public void loadCargo() {
		System.out.println("This bomber begins loading its munitions for deployment...");

	}

	@Override
	public void fly() {
		System.out.println(this.toString());
		double flightTime = this.getRange() / ((double)this.getSpeed());
		System.out.println("This bomber flies for " + flightTime + " hours.");
	}
}
