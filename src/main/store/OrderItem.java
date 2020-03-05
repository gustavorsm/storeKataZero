package store;

public class OrderItem {

	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float calculateTotalFor() {
		float totalItem=0;
		float discount = 0;
		DiscountCalculator discountCalculator = createDiscountCalculator();
		discount = discountCalculator.calculateDiscount(this);
		//totalItem = calculateTotalAmount() - discount;
		return discount;
	}

	private DiscountCalculator createDiscountCalculator() {
		DiscountCalculator discountCalculator = null;
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			discountCalculator = new calculateBooksDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			discountCalculator = new calculateBikesDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			discountCalculator = new calculateCloathingDiscount();
		}
		return discountCalculator;
	}

	private float calculateTotalAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
