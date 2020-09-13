package com.skilldistillery.jet;

public class FighterJet extends Jet implements CombatReady {

	FighterJet(String model, double speed, int range, long price){
		super(model, speed, range, price);
	}
	
	@Override
	public void fight() {
		System.out.println("The " + this.getModel() + " performs a simulated aerial dogfight...");
	}
	
	@Override
	public void fly() {
		System.out.println(this.toString());
		double flightTime = this.getRange() / ((double)this.getSpeed());
		System.out.println("This fighter jet flies for " + flightTime + " hours.");
	}

}
