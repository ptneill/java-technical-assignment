package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public abstract class Discount {
    private final String productName;

    public Discount(String productName) {
        this.productName = productName;
    }

    public String productName() {
        return productName;
    }

    public abstract BigDecimal calculateDiscount(final List<Item> items);
}
