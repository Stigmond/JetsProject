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
			System.out.print("\nPlease make a selection: ");
			int choice = 0;

			try {
				choice = input.nextInt();
			} catch (Exception e) {
				input.nextLine();
				System.out.println("\nInvalid input. Try again.");
			}

			switch (choice) {
			case 1:
				System.out.println("Method 1 goes here");
				break;
			case 2:
				System.out.println("Method 2 goes here");
				break;
			case 3:
				System.out.println("Method 3 goes here");
				break;
			case 4:
				System.out.println("Method 4 goes here");
				break;
			case 5:
				System.out.println("Method 5 goes here");
				break;
			case 6:
				System.out.println("Method 6 goes here");
				break;
			case 7:
				System.out.println("Method 7 goes here");
				break;
			case 8:
				System.out.println("Method 8 goes here");
				break;
			case 9:
				System.out.println("Goodbye!");
				keepGoing = false;
				break;
			default:
				System.out.println("\nPlease select 1 - 9.");
				break;
			}

		}
	}

	public void printMenu() {
		System.out.println("\n1. List Fleet");
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
