package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Discounter {
    private final List<Discount> discounts;

    public Discounter() {
        this.discounts = new ArrayList<>();
    }

    public void includeDiscount(final Discount discount) {
        discounts.add(discount);
    }

    public BigDecimal getDiscount(final List<Item> items) {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        for(Discount discount : discounts) {
            List<Item> specificItems = new ArrayList<>();
            for(Item item : items) {
                if(discount.productName().equals(item.name())) {
                    specificItems.add(item);
                }
            }
            totalDiscount = totalDiscount.add(discount.calculateDiscount(specificItems));
        }
        return totalDiscount;
    }
}
