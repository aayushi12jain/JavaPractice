package strategyPattern;

public class OffroadCar extends Vehicle{
	
	public OffroadCar() {
		super(new SpecialDrive());
	}
}
