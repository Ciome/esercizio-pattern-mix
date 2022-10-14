import java.util.ArrayList;
import java.util.List;

import esercizio.product.Product;
import esercizio.worker.Worker;


public final class Stock {
	//Singleton
	private static Stock instance;
	
	public static Stock getInstance() {
		if (instance == null)
			instance = new Stock();
		return instance;
	}
	
	private List<Product> productsStock = new ArrayList<Product>();	
	
	public void addProduct(Product product) {
		productsStock.add(product);
	}
	
	public void removeProduct(Product product) {
		productsStock.remove(product);
	}
	
	public boolean hasProduct(Product product) {
		return productsStock.contains(product);
	}
	
	public void visitProducts(Worker worker) {
		productsStock.forEach(p -> worker.visitProduct(p));
	}
	
}
