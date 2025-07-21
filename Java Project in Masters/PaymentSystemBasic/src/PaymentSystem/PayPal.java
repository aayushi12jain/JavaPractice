package PaymentSystem;

public class PayPal implements PaymentMethod {
	
	private String emailAddress;

	public PayPal(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing payment of " + amount + " using PayPal account " + emailAddress );
		
	}

	@Override
	public String generateReceipt() {
		return "Receipt: PayPal payment";
	}
	
	

}
