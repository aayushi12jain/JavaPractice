package chainResponsibilityModelLoggerSystem;


public class ErrorLogProcessor extends LoggerHandler{

	public ErrorLogProcessor(LoggerHandler nextLoggerHandler) {
		super(nextLoggerHandler);
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == ERROR) {
			System.out.println("ERROR:" + message);
		}else {
			super.log(logLevel, message);
		}
	}
}
