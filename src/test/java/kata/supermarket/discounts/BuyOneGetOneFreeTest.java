package kata.supermarket.discounts;

import kata.supermarket.Item;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOneGetOneFreeTest {

    @Test
    void discountHasExpectedProductName() {
        final String productName = "product";
        assertEquals(productName, new BuyOneGetOneFree(productName).productName());
    }

    @Test
    void discountGivesZeroDiscountForOne() {
        final String productName = "product";
        final BigDecimal pricePerUnit = new BigDecimal("2.00");
        final List<Item> items = Collections.singletonList(buildItem(productName, pricePerUnit));
        final BuyOneGetOneFree discount = new BuyOneGetOneFree(productName);
        assertEquals(BigDecimal.ZERO, discount.calculateDiscount(items));
    }

    @Test
    void discountGiveCorrectDiscountForTwo() {
        final String productName = "product";
        final BigDecimal pricePerUnit = new BigDecimal("2.00");

        final List<Item> items = new ArrayList<>();
        items.add(buildItem(productName, pricePerUnit));
        items.add(buildItem(productName, pricePerUnit));

        final BuyOneGetOneFree discount = new BuyOneGetOneFree(productName);
        assertEquals(new BigDecimal("2.00"), discount.calculateDiscount(items));
    }

    @Test
    void discountGiveCorrectDiscountForThree() {
        final String productName = "product";
        final BigDecimal pricePerUnit = new BigDecimal("2.00");

        final List<Item> items = new ArrayList<>();
        items.add(buildItem(productName, pricePerUnit));
        items.add(buildItem(productName, pricePerUnit));
        items.add(buildItem(productName, pricePerUnit));

        final BuyOneGetOneFree discount = new BuyOneGetOneFree(productName);
        assertEquals(new BigDecimal("2.00"), discount.calculateDiscount(items));
    }

    Item buildItem(String productName, BigDecimal pricePerUnit) {
        return new Product(productName, pricePerUnit).oneOf();
    }
}
