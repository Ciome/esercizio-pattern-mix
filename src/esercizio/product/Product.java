package esercizio.product;

import esercizio.discount.Discount;
import esercizio.worker.Worker;

public interface Product {
	public String getProductName();
	public long getCost();
	
	//Composite
	public void addProduct(Product product);
	public boolean containsProduct(Product product);
	
	//Visitable
	public void accept(Worker worker);
	
	//Decorator
	public void setDiscount(Discount discount);
	public long applyDiscount(long cost);
}
