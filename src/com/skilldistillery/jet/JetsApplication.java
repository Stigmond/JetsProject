package com.skilldistillery.jet;

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

		Menu(jetArray);
		input.close();
	}

	public void Menu(List<Jet> jetArray) {

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
				printJets(jetArray);
				break;

			case 2:
				flyJets(jetArray);
				break;

			case 3:
				fastestJet(jetArray);
				break;

			case 4:
				longestRange(jetArray);
				break;

			case 5:
				loadCargo(jetArray);
				break;

			case 6:
				dogfight(jetArray);
				break;

			case 7:
				extinguishFire(jetArray);
				break;

			case 8:
				bombTarget(jetArray);
				break;

			case 9:

			case 10:
				break;

			case 11:
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
		System.out.println("");
		System.out.println("1. List Fleet");
		System.out.println("2. Fly All Jets");
		System.out.println("3. View Fastest Jet");
		System.out.println("4. View Jet with Longest Range");
		System.out.println("5. Load All Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Extinguish a Fire");
		System.out.println("8. Bomb a Target");
		System.out.println("9. Add a Jet to Fleet");
		System.out.println("10. Remove a Jet from Fleet");
		System.out.println("11. Quit");
	}

	public void printJets(List<Jet> jetArray) {

		System.out.println("\nThe following jets are located on this Airfield: \n");
		for (Jet jet : jetArray) {
			System.out.println(jet);
		}
	}

	public void flyJets(List<Jet> jetArray) {

		for (int i = 0; i < jetArray.size(); i++) {
			System.out.println("\nJet No. " + (i + 1) + " is on the tarmac...");
			jetArray.get(i).fly();
		}
	}

	public void fastestJet(List<Jet> jetArray) {
		double fastestSpeed = 0;
		int index = 0;
		for (int i = 0; i < jetArray.size(); i++) {
			if (jetArray.get(i).getSpeed() > fastestSpeed) {
				fastestSpeed = jetArray.get(i).getSpeed();
				index = i;
			}
		}
		System.out.println("\nThe fastest jet on this Airfield is: " + jetArray.get(index));
		System.out.printf("This jet travels at a speed of Mach %.1f.%n", jetArray.get(index).getSpeedInMach());
	}

	public void longestRange(List<Jet> jetArray) {
		int rangeMax = 0;
		int index = 0;
		for (int i = 0; i < jetArray.size(); i++) {
			if (jetArray.get(index).getRange() > rangeMax) {
				rangeMax = jetArray.get(index).getRange();
				index = i;
			}
		}
		System.out.println("\nThe jet with the longest range is: " + jetArray.get(index));
	}

	public void loadCargo(List<Jet> jetArray) {
		for (Jet jet : jetArray) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			} else {
				continue;
			}
		}
	}

	public void dogfight(List<Jet> jetarray) {
		for (Jet jet : jetarray) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			} else if (jet instanceof BomberJet) {
				((BomberJet) jet).fight();
			} else {
				continue;
			}
		}
	}

	public void extinguishFire(List<Jet> jetarray) {
		for (Jet jet : jetarray) {
			if (jet instanceof AerialFireFighter) {
				((AerialFireFighter) jet).loadCargo();
				((AerialFireFighter) jet).releaseCargo();
			} else {
				continue;
			}
		}
	}
	
	public void bombTarget(List<Jet> jetarray) {
		for (Jet jet : jetarray) {
			if (jet instanceof BomberJet) {
				((BomberJet) jet).loadCargo();
				((BomberJet) jet).releaseCargo();
			} else {
				continue;
			}
		}
	}
}
