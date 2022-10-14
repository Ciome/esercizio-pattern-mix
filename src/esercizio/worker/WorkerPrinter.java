package esercizio.worker;

import esercizio.product.Product;
import esercizio.product.ProductBundle;
import esercizio.product.ProductSingle;

public class WorkerPrinter implements Worker {
	
	@Override
	public void visitProduct(Product product) {
		product.accept(this);
	}

	@Override
	public void visitProductSingle(ProductSingle product) {
		System.out.println("Prodotto: " + product.getProductName() + ", Costo: " + product.getCost());
	}

	@Override
	public void visitProductBundle(ProductBundle product) {
		System.out.println("Bundle: " + product.getProductName() + ", Costo: " + product.getCost());
		System.out.print("Prodotti inclusi\n{\n");
		product.getIncludedProducts().forEach(s -> visitProduct(s));
		System.out.println("}");
	}

}
