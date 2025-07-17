package strategyPattern;

public class Vehicle {

	Drive driveObj;
	//constructor injection
	public Vehicle(Drive d) {
		this.driveObj = d;
	}
	
	public void drive() {
		driveObj.driveStrategy();
	}
}
