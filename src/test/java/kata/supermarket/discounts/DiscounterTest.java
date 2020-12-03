package kata.supermarket.discounts;

import kata.supermarket.Item;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscounterTest {

    @Test
    void discountsAppliedInMixedBasket() {
        final String nonDiscountedProductName = "non-discounted product";
        final String discountedProductName = "discounted product";
        final BigDecimal pricePerUnit = new BigDecimal("2.00");

        final List<Item> items = new ArrayList<>();
        items.add(buildItem(discountedProductName, pricePerUnit));
        items.add(buildItem(nonDiscountedProductName, pricePerUnit));
        items.add(buildItem(discountedProductName, pricePerUnit));
        items.add(buildItem(nonDiscountedProductName, pricePerUnit));

        final Discounter discounter = new Discounter();
        discounter.includeDiscount(new BuyOneGetOneFree(discountedProductName));

        assertEquals(new BigDecimal("2.00"), discounter.getDiscount(items));
    }

    Item buildItem(String productName, BigDecimal pricePerUnit) {
        return new Product(productName, pricePerUnit).oneOf();
    }
}
