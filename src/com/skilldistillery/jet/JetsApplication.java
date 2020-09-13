package com.skilldistillery.jet;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	private AirField airfield;
	private Scanner input;

	public JetsApplication() {
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
			int choice = -1;

			try {
				choice = input.nextInt();
				input.nextLine();
			} catch (Exception e) {

				System.out.println("\nInvalid input. Try again.");
				input.nextLine();
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
				addJet(jetArray);
				break;

			case 10:
				removeJet(jetArray);
				break;

			case 11:
				System.out.println("\nGoodbye!");
				keepGoing = false;
				break;

			default:
				System.out.println("\nPlease select 1 - 11.");
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

		System.out.println("\nThe following are in the fleet: \n");
		System.out.println("----------------");
		for (Jet jet : jetArray) {
			System.out.println(jet);
		}
		System.out.println("----------------");
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
		System.out.println("\nThe fastest jet in this fleet is: " + jetArray.get(index));
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
		System.out.println("\nThe jet with the longest range in this fleet is: " + jetArray.get(index));
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

	public void addJet(List<Jet> jetArray) {

		boolean addAnother = false;

		do {
			System.out.print("\nPlease enter the new jet model: ");
			String newModel = input.nextLine();

			double newSpeed = 0.0;
			boolean validSpeed = false;
			while (!validSpeed) {
				System.out.print("Please enter the top speed of the " + newModel + " (in MPH): ");
				try {
					newSpeed = (double) input.nextDouble();
					if (newSpeed >= 0) {
						validSpeed = true;
					} else {
						System.out.println("Invalid input.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input.");
					input.nextLine();
				}
			}

			int newRange = 0;
			boolean validRange = false;
			while (!validRange) {
				System.out.print("Please enter the maximum range of the " + newModel + " (in miles): ");
				try {
					newRange = input.nextInt();
					if (newRange >= 0) {
						validRange = true;
					} else {
						System.out.println("Invalid input.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input.");
					input.nextLine();
				}
			}

			long newPrice = 0;
			boolean validPrice = false;
			while (!validPrice) {
				System.out.print("Please enter the price of the " + newModel + ": $");
				try {
					newPrice = input.nextLong();
					if (newPrice >= 0) {
						validPrice = true;
					} else {
						System.out.println("Invalid input.");
					}
					input.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input.");
				}
			}

			Jet newJet = new JetImpl(newModel, newSpeed, newRange, newPrice);
			jetArray.add(newJet);

			System.out.println("\n..." + newModel + " successfully added!");

			String yesNo = null;
			boolean validResponse = false;
			while (!validResponse) {
				System.out.print("\nAdd another jet? (Y/N)");
				yesNo = (input.nextLine()).toLowerCase();
				if (yesNo.equals("no") || yesNo.equals("n")) {
					validResponse = true;
					addAnother = false;
				} else if (yesNo.equals("yes") || yesNo.equals("y")) {
					validResponse = true;
					addAnother = true;
					this.printJets(jetArray);
				} else {
					System.out.println("\nPlease enter (Y)es or (N)o.");
				}

			}
		} while (addAnother);
	}

	public void removeJet(List<Jet> jetArray) {
		System.out.println("\nThe following are in the fleet: \n");
		System.out.println("----------------");
		for (int i = 0; i < jetArray.size(); i++) {
			System.out.println("Jet (" + (i + 1) + ") [Model: " + jetArray.get(i).getModel() + ", Price: $"
					+ jetArray.get(i).getPrice() + ", Speed(MPH): " + jetArray.get(i).getSpeed() + ", Range(miles): "
					+ jetArray.get(i).getRange() + "]");
		}
		System.out.println("----------------");

		int remove = 0;
		boolean validRemove = false;
		while (!validRemove) {
			System.out.print("\nPlease enter the number of the Jet you would like to remove: ");
			try {
				remove = input.nextInt();
				if ((remove > 0) && (remove < jetArray.size() + 1)) {
					validRemove = true;
				} else {
					System.out.println("Invalid number.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
				input.nextLine();
			}
		}
		jetArray.remove((remove - 1));
		System.out.println("\n...Jet No. " + remove + " has been removed.");
	}
}
