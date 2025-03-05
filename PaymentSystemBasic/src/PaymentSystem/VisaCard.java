package PaymentSystem;

public class VisaCard extends CreditCard{

	private String cardHolderName;

	public VisaCard(String cardNumber, String cardHolderName) {
		super(cardNumber);
		this.cardHolderName = cardHolderName;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing payment of " + amount + " using VisaCard " + getCardNumnber() + " held by " + cardHolderName );
		
	}

	@Override
	public String generateReceipt() {
		return ("Receipt: VisaCard payment by " + cardHolderName);
	}
	
	
}
