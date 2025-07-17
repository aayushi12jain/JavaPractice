package chainResponsibilityModelATMSystem;

public class Fifties extends NotesHandler{
	
	private static int notes_50 = 3;
	
	public Fifties(NotesHandler notes) {
		super(notes);
	}
	
	public void withdraw(int amount) {
		int notes_count = 0;
		if(amount>=50) {
			while(amount>=50) {
				notes_count++;
				amount = amount - 50;
			}
		}
		System.out.println("You are getting " + notes_count + " of 50 rs notes.");
		notes_50 = notes_50 - notes_count;
		if(amount > 0) {
			super.withdraw(amount);
		}
	}
	
}
