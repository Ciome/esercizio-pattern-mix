import java.util.ArrayList;
import java.util.List;

import esercizio.payment.PaymentStrategy;
import esercizio.product.Product;

public class Client implements ClientInterface {
	
	private String clientName;
	private Cart cart;
	private PaymentStrategy paymentMethod;
	private List<Product> ownedProducts = new ArrayList<Product>();
	
	
	public Client(String clientName) {
		this.clientName = clientName;
		this.cart = new Cart();
	}

	@Override
	public void update(String notification) {
		System.out.println("Il cliente " + this.getClientName() + " ha ricevuto il messaggio:\n" + notification);
	}

	public String getClientName() {
		return clientName;
	}
	
	public void addToCart(Product prodotto) {
		cart.addProduct(prodotto);
	}
	
	public void removeFromCart(Product prodotto) {
		cart.removeProduct(prodotto);
	}
	
	public void addPaymentMethod(PaymentStrategy paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public void checkout() {
		if (cart.isCartValid())
		{
			if (paymentMethod != null) {
				paymentMethod.pay(cart.getCost());
				ownedProducts.addAll(cart.checkout());
			} else System.out.println("Nessun metodo di pagamento inserito, impossibile pagare");
		}
		else System.out.println("Carrello non valido, impossibile pagare");	
	}
	
}
