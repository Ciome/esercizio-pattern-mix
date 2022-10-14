package esercizio.discount;

public class DiscountHalf implements Discount {
	
	private float discount;
	
	public DiscountHalf(float percent) {
		this.discount = Math.max(Math.min(percent, 1.0f), 0.0f);
	}
	
	@Override
	public long applyDiscount(long cost) {
		return Math.round(cost * this.discount);
	}

}
