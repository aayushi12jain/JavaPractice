package chainResponsibilityModelATMSystem;

public abstract class NotesHandler {
	
	public static int RS_2000 = 1;
	public static int RS_5000 = 2;
	public static int RS_100 = 3;
	public static int RS_50 = 4;
	
	NotesHandler notesHandler;
	
	public NotesHandler(NotesHandler notes) {
		this.notesHandler = notes;
	}
	
	public void withdraw(int amount) {
		if(this.notesHandler != null) {
			this.notesHandler.withdraw(amount);
		}
	}

}
