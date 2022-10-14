package esercizio.product;

import esercizio.discount.Discount;
import esercizio.worker.Worker;

public class ProductSingle implements Product {
	
	private String productName;
	private long cost;
	private Discount discount;

	public ProductSingle(String productName, long cost) {
		this.productName = productName;
		this.cost = cost;
	}

	@Override
	public void addProduct(Product product) {
	}

	@Override
	public long getCost() {
		return applyDiscount(this.cost);
	}

	@Override
	public boolean containsProduct(Product product) {
		return false;
	}

	@Override
	public String getProductName() {
		return productName;
	}

	@Override
	public void accept(Worker worker) {
		worker.visitProductSingle(this);
	}
	
	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public long applyDiscount(long cost) {
		if (discount != null)
			return discount.applyDiscount(cost);
		else return cost;
	}

}
