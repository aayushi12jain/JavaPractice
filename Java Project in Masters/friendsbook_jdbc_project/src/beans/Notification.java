package beans;

public class Notification {
	private String notificationId;
	private String nType;
	private String nMessage;
	private String nDateTime;
	private String nStatus;
	private String nUsername;
	
	
	public Notification(String notificationId, String nType, String nMessage, String nDateTime, String nStatus,
			String nUsername) {
		super();
		this.notificationId = notificationId;
		this.nType = nType;
		this.nMessage = nMessage;
		this.nDateTime = nDateTime;
		this.nStatus = nStatus;
		this.nUsername = nUsername;
	}

	public Notification(String nType, String nMessage, String nStatus, String nUsername) {
		super();
		this.nType = nType;
		this.nMessage = nMessage;
		this.nDateTime = new DateAndTime().DateTime();
		this.nStatus = nStatus;
		this.nUsername = nUsername;
	}

	public String getNotificationId() {
		return notificationId;
	}
	
	public String getnType() {
		return nType;
	}
	public void setnType(String nType) {
		this.nType = nType;
	}
	public String getnMessage() {
		return nMessage;
	}
	public void setnMessage(String nMessage) {
		this.nMessage = nMessage;
	}
	public String getnDateTime() {
		return nDateTime;
	}
	
	public String getnStatus() {
		return nStatus;
	}
	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}
	public String getnUsername() {
		return nUsername;
	}
	public void setnUsername(String nUsername) {
		this.nUsername = nUsername;
	}
	
	
	

}
