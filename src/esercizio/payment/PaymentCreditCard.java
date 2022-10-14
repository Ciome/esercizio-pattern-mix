package esercizio.payment;

public class PaymentCreditCard implements PaymentStrategy {

	@Override
	public void pay(long cost) {
		System.out.println("pagato " + cost + " con carta di credito");
	}

}
