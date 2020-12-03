package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public class BuyOneGetOneFree extends Discount {

    public BuyOneGetOneFree(String productName) {
        super(productName);
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        BigDecimal discount = BigDecimal.ZERO;
        boolean addNextToDiscount = false;
        for (Item item : items) {
            if (addNextToDiscount) {
                discount = discount.add(item.price());
            }
            addNextToDiscount = !addNextToDiscount;
        }
        return discount;
    }
}
