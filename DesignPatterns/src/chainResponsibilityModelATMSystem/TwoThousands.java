package chainResponsibilityModelATMSystem;

public class TwoThousands extends NotesHandler{
	
	private static int notes_2000 = 3;
	
	public TwoThousands(NotesHandler notes) {
		super(notes);
	}
	
	public void withdraw(int amount) {
		int notes_count = 0;
		if(amount>=2000) {
			while(amount>=2000) {
				notes_count++;
				amount = amount -2000;
			}
		}
		System.out.println("You are getting " + notes_count + " of 2000 rs notes.");
		notes_2000 = notes_2000 - notes_count;
		if(amount > 0) {
			super.withdraw(amount);
		}
	}
	
}
