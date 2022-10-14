import esercizio.discount.DiscountRename;
import esercizio.payment.PaymentCreditCard;
import esercizio.product.ProductBundle;
import esercizio.product.ProductSingle;
import esercizio.worker.WorkerPrinter;

public class EsercizioPatternMix {

	public static void main(String[] args) {
		Client c1 = new Client("cliente1");
		ShopEventManager.getInstance().subscribe(c1);
		
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
		
		b1.setDiscount(new DiscountRename(0.7f));
				
		Stock.getInstance().addProduct(p1);
		Stock.getInstance().addProduct(p2);
		Stock.getInstance().addProduct(b1);
		
		WorkerPrinter wp = new WorkerPrinter();
		Stock.getInstance().visitProducts(wp);
		
		Client c2 = new Client("cliente2");
		c2.addToCart(p1);
		c2.addToCart(b1);
		c2.addPaymentMethod(new PaymentCreditCard());
		
		c2.checkout();
		
	}
}
