package strategyPattern;

public class PassengerCar extends Vehicle {

	public PassengerCar() {
		super(new NormalDrive());
	}
}
