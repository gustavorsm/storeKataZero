package store;

public class calculateBooksDiscount implements DiscountCalculator {
    public float calculateDiscount(OrderItem item) {
        float discount;
        float itemAmount = item.getProduct().getUnitPrice() * item.getQuantity();
        float booksDiscount = 0;
        if (itemAmount >= 100) {
            booksDiscount = itemAmount * 10 / 100;
        }
        discount = itemAmount - booksDiscount;
        return discount;
    }
}
