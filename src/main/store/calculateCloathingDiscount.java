package store;

public class calculateCloathingDiscount implements DiscountCalculator {

    public static final int MIN_ITEM_QUANTITY = 2;

    public float calculateDiscount(OrderItem item) {
        float discount;
        float itemAmount = item.getProduct().getUnitPrice() * item.getQuantity();
        float cloathingDiscount = calculateCloathinDiscount(item);
        discount = itemAmount - cloathingDiscount;
        return discount;
    }

    private boolean isQuantityGreaterThanMinQty(int quantity) {
        return quantity > MIN_ITEM_QUANTITY;
    }

    private float calculateCloathinDiscount(OrderItem item) {
        float cloathingDiscount = 0;
        if (isQuantityGreaterThanMinQty(item.getQuantity())) {
            cloathingDiscount = item.getProduct().getUnitPrice();
        }
        return cloathingDiscount;
    }
}