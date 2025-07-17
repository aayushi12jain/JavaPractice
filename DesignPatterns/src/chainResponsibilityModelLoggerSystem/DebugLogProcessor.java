package chainResponsibilityModelLoggerSystem;


public class DebugLogProcessor extends LoggerHandler{

	public DebugLogProcessor(LoggerHandler nextLoggerHandler) {
		super(nextLoggerHandler);
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == DEBUG) {
			System.out.println("DEBUG:" + message);
		}else {
			super.log(logLevel, message);
		}
	}
}
