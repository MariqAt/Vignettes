package DriverAndOilStation;

import java.util.ArrayList;

import Vehicle.Vehicle;
import Vinetki.Vinetki;
import Vinetki.Vinetki.ValidPeriod;

public class Driver {

	private String name;
	private ArrayList<Vehicle> vehicleList;
	private double money;
	private OilStation benzinostanciq;
	
	public Driver(String name, double money, OilStation benzinostanciq) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (money > 0) {
			this.money = money;
		}
		if (benzinostanciq != null) {
			this.benzinostanciq = benzinostanciq;
		}
		vehicleList = new ArrayList<>();
		
	}

	public void buyVinetki (ValidPeriod period) {
		for (int i = 0; i < vehicleList.size(); i++) {
			buyVinetka(i, period);
		}
	}
	
	public void buyVinetka (int number, ValidPeriod period) {
		Vinetki newVinetka = benzinostanciq.sellVinetka(vehicleList.get(number).getType(), period);
		this.money -= newVinetka.getPriceVinetka();
		vehicleList.get(number).putVinetka(newVinetka);
	}
	
	public ArrayList<Vehicle> getVehicle() {
		return vehicleList;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}

	public void printInfoForDriver() {
		System.out.println("---Info---");
		System.out.println(this.name + " кара: " + vehicleList.size() + " автомобила.");
		System.out.println("Останали пари: " + this.money + " лв.");
		
	}
	
	
}
