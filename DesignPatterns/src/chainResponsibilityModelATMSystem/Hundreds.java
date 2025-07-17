package chainResponsibilityModelATMSystem;

public class Hundreds extends NotesHandler{
	
	private static int notes_100 = 3;
	
	public Hundreds(NotesHandler notes) {
		super(notes);
	}
	
	public void withdraw(int amount) {
		int notes_count = 0;
		if(amount>=100) {
			while(amount>=100) {
				notes_count++;
				amount = amount -100;
			}
		}
		System.out.println("You are getting " + notes_count + " of 100 rs notes.");
		notes_100 =notes_100 - notes_count;
		if(amount > 0) {
			super.withdraw(amount);
		}
	}
	
}
