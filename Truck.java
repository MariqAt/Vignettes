package Vehicle;

import Vinetki.Vinetki.TypeVehicle;
import Vinetki.Vinetki.ValidPeriod;

public class Truck extends Vehicle {
	
	
	public Truck(String model, int yearOfManifactory) {
		super(model, yearOfManifactory, TypeVehicle.TRUCK);
	}


}
