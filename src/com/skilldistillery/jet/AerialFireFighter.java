package com.skilldistillery.jet;

public class AerialFireFighter extends Jet implements CargoCarrier, Discharges {

	AerialFireFighter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void releaseCargo() {
		System.out.println("This " + this.getModel() + " deploys its payload over the forest fire...");
	}

	@Override
	public void loadCargo() {
		System.out.println("This " + this.getModel() + " loads up with water and fire suppressants...");

	}

	@Override
	public void fly() {
		System.out.println(this.toString());
		double flightTime = this.getRange() / ((double)this.getSpeed());
		System.out.println("This aerial fire fighter flies for " + flightTime + " hours.");
	}
}
