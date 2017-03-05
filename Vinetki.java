package Vinetki;

public class Vinetki {

	public enum TypeVehicle {
		CAR(5, "Blue"), TRUCK(7, "Yellow"), BUS(9, "Red");
		
		private double price;
		private String color;
		
		private TypeVehicle (double price, String color) {
			this.price = price;
			this.color = color;
		}  
	}
	
	public enum ValidPeriod {
		DAY(1), MONTH(10), YEAR(60);
		
		private double coefficient;
		
		private ValidPeriod (double coefficient) {
			this.coefficient = coefficient;
		}
	}
	
	private String date;
	private TypeVehicle type; //car, truck, bus
	private ValidPeriod period; // dnecna, mesechna, godishna
	private double priceVinetka;
	private String color;
	private boolean isStick;
	
	
	public Vinetki(TypeVehicle type, ValidPeriod period) {
		this.type = type;
		this.period = period;
		this.priceVinetka = calcPriceVinetka();
		this.color = setColor();
		isStick = false;
	}
	
	public int stickOnTheGlass(Vinetki vin) {
		if (!isStick) {
			isStick = true;
			if (vin.getType().equals("Car")) { 
				return 5;
			}
			if (vin.getPeriod().equals("Bus")) { 
				return 20;
			}
			if (vin.getPeriod().equals("Truck")) { 
				return 10;
			}
		}
		return 0;
	}

	public String setColor () {
		return type.color;
	}
	
	public double calcPriceVinetka () {
		return type.price * period.coefficient;
	}

	public TypeVehicle getType() {
		return type;
	}


	public ValidPeriod getPeriod() {
		return period;
	}

	public double getPriceVinetka() {
		return priceVinetka;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Vinetki [type=" + type + ", color=" + color + ", period=" + period + ", priceVinetka=" + priceVinetka + "]";
	}
	
	
	
}
