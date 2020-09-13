package com.skilldistillery.jet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	private AirField airfield;
	private Scanner input;

	JetsApplication() {
		airfield = new AirField();
		input = new Scanner(System.in);
	}

	public static void main(String[] args) {

		JetsApplication jetApp1 = new JetsApplication();
		jetApp1.launch();
	}

	public void launch() {

		List<Jet> jetArray = this.airfield.getJetsInAirfield();
		
		Menu();
		input.close();
	}

	public void Menu() {
		
		boolean keepGoing = true;
		while (keepGoing) {
		printMenu();
		keepGoing = false;
		}
	}

	public void printMenu() {
		System.out.println("1. List Fleet");
		System.out.println("2. Fly All Jets");
		System.out.println("3. View Fastest Jet");
		System.out.println("4. View Jet with Longest Range");
		System.out.println("5. Load All Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a Jet to Fleet");
		System.out.println("8. Remove a Jet from Fleet");
		System.out.println("9. Quit");
	}
}

