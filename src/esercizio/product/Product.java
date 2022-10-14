package esercizio.product;

import esercizio.worker.Worker;

public interface Product {
	public String getProductName();
	public long getCost();
	
	//Composite
	public void addProduct(Product product);
	public boolean contieneContenitore(Product contenitore);
	
	//Visitable
	public void accept(Worker worker);
	
	//Decorator
	public long applyDiscount(long cost);
}
