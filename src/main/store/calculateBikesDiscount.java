package store;

public class calculateBikesDiscount implements DiscountCalculator {
    public float calculateDiscount(OrderItem item) {
        float discount;
        float itemAmount = item.getProduct().getUnitPrice() * item.getQuantity();
        discount = itemAmount - itemAmount * 20 / 100;
        return discount;
    }
}
