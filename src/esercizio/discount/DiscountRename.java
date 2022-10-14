package esercizio.discount;

public class DiscountRename implements Discount {
	
	private float discount;
	
	/**
	 * @param percent
	 * a quanto il prezzo originale viene ridotto in percentuale, deve essere un valore tra 0 e 1
	 */
	public DiscountRename(float percent) {
		this.discount = Math.max(Math.min(percent, 1.0f), 0.0f);
	}
	
	@Override
	public long applyDiscount(long cost) {
		return Math.round(cost * this.discount);
	}

}
