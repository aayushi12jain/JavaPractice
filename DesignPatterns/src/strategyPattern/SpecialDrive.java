package strategyPattern;

public class SpecialDrive implements Drive {


	@Override
	public void driveStrategy() {
		System.out.println("Drive specially");
	}
}
