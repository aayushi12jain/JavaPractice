package observerPattern;

public class MobileNotification implements NotifyObserver{
	
	String phoneNumber;
	StockObservable o;
	
	public MobileNotification(String pn, StockObservable obj) {
		this.phoneNumber = pn;
		this.o = obj;
	}

	@Override
	public void update() {
		sendMsgOnPhone();
	}
	
	public void sendMsgOnPhone() {
		System.out.println("msg to " + this.phoneNumber + " : Iphone is back in stock.");
	}

	
}
