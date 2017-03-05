package DriverAndOilStation;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import Vehicle.Vehicle;
import Vinetki.Vinetki;
import Vinetki.Vinetki.TypeVehicle;
import Vinetki.Vinetki.ValidPeriod;

public class OilStation {

	private static final int QUANTITY = 1_000;
	private String nameOilStation;
	private TreeMap <TypeVehicle, TreeMap <ValidPeriod, ArrayList<Vinetki>>> sortListOfVinetki; //type -> period => Vinetki
	
	public OilStation(String nameOilStation) {
		if (nameOilStation != null && ! nameOilStation.isEmpty()) {
			this.nameOilStation = nameOilStation;
		}
		sortListOfVinetki = new TreeMap<>();
		createVinetki();
	}
	
	public void createVinetki () {
		ArrayList<Vinetki>	listOfVinetki = new ArrayList<>(QUANTITY);
		for (int i = 0; i < QUANTITY; i++) {
			listOfVinetki.add(new Vinetki(TypeVehicle.values()[new Random().nextInt(TypeVehicle.values().length)], 
							ValidPeriod.values()[new Random().nextInt(ValidPeriod.values().length)]));
		}
		
		for (Vinetki v : listOfVinetki) {
			TypeVehicle type = v.getType();
			ValidPeriod period = v.getPeriod();
			
			if (!sortListOfVinetki.containsKey(type)) {
				sortListOfVinetki.put(type, new TreeMap());
			}
			if (!sortListOfVinetki.get(type).containsKey(period)) {
				sortListOfVinetki.get(type).put(period, new ArrayList<>());
			}
			sortListOfVinetki.get(type).get(period).add(v);
		}
	}
	
	public Vinetki sellVinetka (TypeVehicle type, ValidPeriod period) {
		if (sortListOfVinetki.get(type).get(period).size() > 0) {
			Vinetki copyVin = sortListOfVinetki.get(type).get(period).get(0);
			sortListOfVinetki.get(type).get(period).remove(0);
			return copyVin;
		}
		return null;
	}
	
	public void printInfo () {
		for (Entry<TypeVehicle, TreeMap <ValidPeriod, ArrayList<Vinetki>>> entryType : sortListOfVinetki.entrySet()) {
			System.out.println("-----" + entryType.getKey() + "-----");
			for (Entry<ValidPeriod, ArrayList<Vinetki>> entryPeriod : entryType.getValue().entrySet()) {
				System.out.println("* " + entryPeriod.getKey() + " *");
				for (Vinetki v : entryPeriod.getValue()) {
					System.out.println("- " + v);
				}
			}
			System.out.println();
		}
	}

	public TreeMap<TypeVehicle, TreeMap<ValidPeriod, ArrayList<Vinetki>>> getSortListOfVinetki() {
		return sortListOfVinetki;
	}
	
}
