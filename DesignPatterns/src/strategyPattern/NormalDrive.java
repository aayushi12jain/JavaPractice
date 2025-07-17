package strategyPattern;

public class NormalDrive implements Drive {


	@Override
	public void driveStrategy() {
		System.out.println("Drive normally");
	}
}
