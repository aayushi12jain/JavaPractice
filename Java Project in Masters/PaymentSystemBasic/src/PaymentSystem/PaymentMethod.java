package PaymentSystem;

public interface PaymentMethod {
	void processPayment(double amount);
	String generateReceipt();

}
