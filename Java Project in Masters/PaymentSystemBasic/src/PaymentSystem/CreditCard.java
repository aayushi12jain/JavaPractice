package PaymentSystem;

public abstract class CreditCard implements PaymentMethod{
	
	private String cardNumnber;

	public CreditCard(String cardNumnber) {
		super();
		this.cardNumnber = cardNumnber;
	}

	public String getCardNumnber() {
		return cardNumnber;
	}

	public void setCardNumnber(String cardNumnber) {
		this.cardNumnber = cardNumnber;
	}
	
}
