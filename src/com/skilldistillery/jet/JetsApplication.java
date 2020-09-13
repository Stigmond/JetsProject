package com.skilldistillery.jet;

import java.util.Scanner;

public class JetsApplication {

	private AirField airfield;
	private Scanner input;
	
	JetsApplication(){
		airfield = new AirField();
		input = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
	
		JetsApplication jetApp1 = new JetsApplication();
		jetApp1.launch();	
		
	}
	
	public void launch() {
		displayUserMenu();
		input.close();
	}
	
	public void displayUserMenu() {
		Jet jet1 = new CargoJet("Spruce Goose", 350.00, 1500, 150000);
		airfield.jetArray.add(jet1);
		
		airfield.jetArray.get(0).fly();
	}
}
