package strategyPattern;

public class SportCar extends Vehicle{


	public SportCar() {
		super(new SpecialDrive());
	}
	
}
