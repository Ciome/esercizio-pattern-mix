import esercizio.payment.PaymentCreditCard;
import esercizio.product.ProductBundle;
import esercizio.product.ProductSingle;
import esercizio.worker.WorkerPrinter;

public class EsercizioPatternMix {

	public static void main(String[] args) {
		ProductSingle p1 = new ProductSingle("ProdottoA", 15);
		ProductSingle p2 = new ProductSingle("ProdottoB", 12);
		ProductBundle b1 = new ProductBundle("BundleA");
		ProductSingle p3 = new ProductSingle("ProdottoA", 15);
		ProductSingle p4 = new ProductSingle("ProdottoB", 12);
		b1.addProduct(p4);
		b1.addProduct(p3);
		ProductBundle b2 = new ProductBundle("BundleB");
		b2.addProduct(b1);
		b1.addProduct(b2);
		
		
		
		Stock.getInstance().addProduct(p1);
		Stock.getInstance().addProduct(p2);
		Stock.getInstance().addProduct(b1);
		
		WorkerPrinter wp = new WorkerPrinter();
		Stock.getInstance().visitProducts(wp);
		
		Client c = new Client("cliente1");
		c.addToCart(p1);
		c.addToCart(b1);
		c.addPaymentMethod(new PaymentCreditCard());
		
		c.checkout();
		
	}
}
