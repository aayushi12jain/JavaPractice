package chainResponsibilityModelLoggerSystem;


public class InforLogProcessor extends LoggerHandler{

	public InforLogProcessor(LoggerHandler nextLoggerHandler) {
		super(nextLoggerHandler);
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == INFO) {
			System.out.println("INFO:" + message);
		}else {
			super.log(logLevel, message);
		}
	}
}
