import java.util.ArrayList;
import java.util.List;

import esercizio.product.Product;

public class Cart {
	
	List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void removeProduct(Product product) {
		products.add(product);
	}
	
	public long getCost() {
		long total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getCost();
		}
		return total;
	}
	
	public boolean isCartValid() {
		//Controlla disponibilità dei prodotti
		boolean cartIsValid = true;
		for (int i = 0; i < products.size(); i++) {
			if (!Stock.getInstance().hasProduct(products.get(i))) {
				cartIsValid = false;
				products.remove(i);
			}
		}
		return cartIsValid;		
	}
	
	public List<Product> checkout() {
		List<Product> checkout = new ArrayList<Product>(products);
		
		//Compra e rimuove dallo stock
		for (int i = 0; i < products.size(); i++) {
			Stock.getInstance().removeProduct(products.get(i));
		}
		products = new ArrayList<Product>();
		
		return checkout;
	}
	
}
