package PaymentSystem;

public class PaymentApp {
	
	public static void main(String[] args) {
		PaymentMethod[] payment = new PaymentMethod[2];
		
		payment[0] = new PayPal("aayushi@hotmail.com");
		payment[1] = new VisaCard("**** **** **6757", "Aayushi");
		
		for(PaymentMethod p:payment) {
			p.processPayment(356.90);
			System.out.println(p.generateReceipt());
			System.out.println();
		}
	}

}
