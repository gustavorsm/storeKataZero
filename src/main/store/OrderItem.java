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
		float itemAmount = getProduct().getUnitPrice() * getQuantity();
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			totalItem = discountBooks(itemAmount, itemAmount >= 100, itemAmount * 10 / 100);
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			// 20% discount for Bikes
			totalItem = discountBikes(itemAmount, itemAmount * 20 / 100);
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			totalItem = discountCloathing(itemAmount, getQuantity() > 2, getProduct().getUnitPrice());
		}
		return totalItem;
	}

	private float discountBooks(float itemAmount, boolean b, float v) {
		float totalItem;
		float booksDiscount = 0;
		if (b) {
			booksDiscount = v;
		}
		totalItem = itemAmount - booksDiscount;
		return totalItem;
	}

	private float discountBikes(float itemAmount, float v) {
		float totalItem;
		totalItem = itemAmount - v;
		return totalItem;
	}

	private float discountCloathing(float itemAmount, boolean b, float unitPrice) {
		float totalItem;
		float cloathingDiscount = 0;
		if (b) {
			cloathingDiscount = unitPrice;
		}
		totalItem = itemAmount - cloathingDiscount;
		return totalItem;
	}
}
