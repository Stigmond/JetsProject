package com.skilldistillery.jet;

public class JetImpl extends Jet{

	JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fly() {
		System.out.println(this.toString());
		double flightTime = this.getRange() / ((double)this.getSpeed());
		System.out.println("This jet flies for " + flightTime + " hours.");
	}
}
