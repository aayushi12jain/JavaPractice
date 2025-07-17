package chainResponsibilityModelATMSystem;

public class FiveHundreds extends NotesHandler{
	
	private static int notes_500 = 3;
	
	public FiveHundreds(NotesHandler notes) {
		super(notes);
	}
	
	public void withdraw(int amount) {
		int notes_count = 0;
		if(amount>=500) {
			while(amount>=500) {
				notes_count++;
				amount = amount -500;
			}
		}
		System.out.println("You are getting " + notes_count + " of 500 rs notes.");
		notes_500 = notes_500 - notes_count;
		if(amount > 0) {
			super.withdraw(amount);
		}
	}
	
}
