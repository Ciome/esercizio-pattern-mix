package esercizio.payment;

public class PaymentCreditCard implements PaymentMethod {

	@Override
	public void pay(long cost) {
		System.out.println("pagato " + cost + " con carta di credito");
	}

}
