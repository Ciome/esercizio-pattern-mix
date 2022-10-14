package esercizio.worker;

import esercizio.product.Product;
import esercizio.product.ProductBundle;
import esercizio.product.ProductSingle;

//Visitor
public interface Worker {
	public void visitProduct(Product product);
	public void visitProductSingle(ProductSingle product);
	public void visitProductBundle(ProductBundle product);
}
