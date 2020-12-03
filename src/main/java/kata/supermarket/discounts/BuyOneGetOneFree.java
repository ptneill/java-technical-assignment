package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public class BuyOneGetOneFree extends Discount {

    BuyOneGetOneFree(String productName) {
        super(productName);
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        return BigDecimal.ZERO;
    }
}
