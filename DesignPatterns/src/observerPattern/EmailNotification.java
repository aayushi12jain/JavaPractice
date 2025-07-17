package observerPattern;

public class EmailNotification implements NotifyObserver{
	
	String email;
	StockObservable o;
	
	public EmailNotification(String email, StockObservable observeItem ) {
		this.email = email;
		this.o = observeItem;
	}

	@Override
	public void update() {
		sendEmail();
	}

	private void sendEmail() {
		System.out.println("Iphone is back in stock." + this.email);
	}

}
