package chainResponsibilityModelLoggerSystem;

public abstract class LoggerHandler {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	LoggerHandler nextLoggerHandler;
	
	public LoggerHandler(LoggerHandler nextLoggerHandler) {
		this.nextLoggerHandler = nextLoggerHandler;
	}
	
	public void log(int logLevel, String message) {
		if(this.nextLoggerHandler!=null) {
			this.nextLoggerHandler.log(logLevel, message);
		}
	}
}
