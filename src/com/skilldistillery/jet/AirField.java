package com.skilldistillery.jet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jet> jetsInAirfield;

	public AirField() {
		jetsInAirfield = new ArrayList<>();
		jetsInAirfield = fillJetArray("jets.txt");
	}

	private List<Jet> fillJetArray(String fileName) {

		List<Jet> tempArray = new ArrayList<>();
		System.out.println("Loading Airfield Inventory...");
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields[0].equals("Jet")) {
					Jet tempJet = new JetImpl(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Integer.parseInt(fields[4]));
					tempArray.add(tempJet);
				}
				if (fields[0].equals("BomberJet")) {
					Jet tempJet = new BomberJet(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Integer.parseInt(fields[4]));
					tempArray.add(tempJet);
				}
				if (fields[0].equals("CargoJet")) {
					Jet tempJet = new CargoJet(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Integer.parseInt(fields[4]));
					tempArray.add(tempJet);
				}
				if (fields[0].equals("FighterJet")) {
					Jet tempJet = new FighterJet(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Integer.parseInt(fields[4]));
					tempArray.add(tempJet);
				}
				if (fields[0].equals("AerialFireFighter")) {
					Jet tempJet = new AerialFireFighter(fields[1], Double.parseDouble(fields[2]),
							Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
					tempArray.add(tempJet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		System.out.println("Complete!");
		return tempArray;
	}

	@Override
	public String toString() {
		return "AirField [jetsInAirfield=" + jetsInAirfield + "]";
	}

	public List<Jet> getJetsInAirfield() {
		return jetsInAirfield;
	}

	public void setJetsInAirfield(List<Jet> jetsInAirfield) {
		this.jetsInAirfield = jetsInAirfield;
	}

}
