package esercizio.payment;

public class PaymentPayPal implements PaymentStrategy {

	@Override
	public void pay(long cost) {
		System.out.println("pagato " + cost + " con PayPal");
	}

}
