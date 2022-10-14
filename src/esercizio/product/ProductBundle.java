package esercizio.product;
import java.util.ArrayList;
import java.util.List;

import esercizio.discount.Discount;
import esercizio.worker.Worker;

public class ProductBundle implements Product {
	
	private String bundleName;
	private List<Product> includedProducts;
	private Discount discount;
	
	public ProductBundle(String bundleName) {
		this.bundleName = bundleName;
		this.includedProducts = new ArrayList<Product>();
	}
	
	//Forse va levato
	public ProductBundle(ArrayList<Product> products) {
		this.includedProducts = new ArrayList<Product>();
	}
	
	@Override
	public void addProduct(Product product) {
		if (!product.contieneContenitore(this)) {
			this.includedProducts.add(product);
			System.out.println("prodotto inserito");
		} else System.out.println("impossibile inserire");
	}

	@Override
	public long getCost() {
		long sum = 0;
		for (int i = 0; i < includedProducts.size(); i++) {
			sum += includedProducts.get(i).getCost();
		}
		return sum;
	}

	@Override
	public boolean contieneContenitore(Product contenitore) {
		if (contenitore.equals(this)) return true;
		for (int i = 0; i < includedProducts.size(); i++) {
			if (includedProducts.get(i).contieneContenitore(contenitore)) return true; 
		}
		return false;
	}

	@Override
	public String getProductName() {
		//TODO: get Nome dei prodotti contenuti
		return this.bundleName;
	}

	@Override
	public void accept(Worker worker) {
		worker.visitProductBundle(this);
	}

	public List<Product> getIncludedProducts() {
		return includedProducts;
	}


	@Override
	public long applyDiscount(long cost) {
		if (discount != null)
			return discount.applyDiscount(cost);
		return discount.applyDiscount(cost);
	}

}
