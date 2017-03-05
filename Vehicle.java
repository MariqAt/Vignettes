package Vehicle;

import Vinetki.Vinetki;
import Vinetki.Vinetki.TypeVehicle;
import Vinetki.Vinetki.ValidPeriod;

public abstract class Vehicle {

	private String model;
	private Vinetki vinetka;
	private int yearOfManifactory;
	private TypeVehicle type;
	
	public Vehicle(String model, int yearOfManifactory, TypeVehicle type) {
		if (model != null && model.isEmpty()) {
			this.model = model;
		}
		if (yearOfManifactory > 1980) {
			this.yearOfManifactory = yearOfManifactory;
		}
		this.type = type;
	}

	public void putVinetka (Vinetki newVinetka) {
		newVinetka.stickOnTheGlass(newVinetka);
		this.vinetka = newVinetka;
	}
	public TypeVehicle getType() {
		return type;
	}

	public Vinetki getVinetka() {
		return vinetka;
	}
	
	
}
