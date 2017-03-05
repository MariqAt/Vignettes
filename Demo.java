package Demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import DriverAndOilStation.Driver;
import DriverAndOilStation.OilStation;
import Vehicle.Bus;
import Vehicle.Car;
import Vehicle.Truck;
import Vehicle.Vehicle;
import Vinetki.Vinetki.ValidPeriod;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1
		OilStation benzinostanciq = new OilStation("OMV");
		benzinostanciq.printInfo();
		
		//2
		String[] names = {"Petar", "Dragomir", "Svetoslav", "Canko", "Dencho", "Ivan", "Hristo", "Stamat"};
		double[] money = {6500, 6100, 4900, 5900, 6000, 5700, 6200};
		
		ArrayList<Driver> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new Driver(names[new Random().nextInt(names.length)], money[new Random().nextInt(money.length)], benzinostanciq));
		}
		
		//3
		ArrayList<Vehicle> avtomobili = new ArrayList<>();
		
		for (int i = 0; i < 200; i++) {
			switch (new Random().nextInt(3)) {
			case 0:
				avtomobili.add(new Car("Golf", 2005));
				break;
			case 1:
				avtomobili.add(new Bus("Man", 2006));
				break;
			case 2:
				avtomobili.add(new Truck("Scania", 2011));
				break;
			}
		}
		for (int i = 0; i < drivers.size(); i++) {
			int broiAvt = 10;
			while (broiAvt > 0) {
				int idx = new Random().nextInt(avtomobili.size());
				drivers.get(i).addVehicle(avtomobili.get(idx));
				avtomobili.remove(idx);
				broiAvt--;
			}
		}
		//4

		for (int i = 0; i < drivers.size(); i++) {
			if (i % 3 == 0) {
				int buyVinetki = 5;
				while (buyVinetki > 0) {
					int idx = new Random().nextInt(drivers.get(i).getVehicle().size());
					if (drivers.get(i).getVehicle().get(idx).getVinetka() == null) {
						drivers.get(i).buyVinetka(idx, ValidPeriod.values()[new Random().nextInt(ValidPeriod.values().length)]);
						buyVinetki--;
					}
				}
			} else {
				drivers.get(i).buyVinetki(ValidPeriod.values()[new Random().nextInt(ValidPeriod.values().length)]);
			}
		}
		
		//5
		for (Driver dr : drivers) {
			dr.printInfoForDriver();
		}
		
		//6
		System.out.println();
		System.out.println("-----—œ»—⁄  Õ¿ ¬»Õ≈“ » —À≈ƒ œ–Œƒ¿∆¡¿-----");
		benzinostanciq.printInfo();

	}

}
