package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final String name = "product";
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product(name, price).oneOf().price());
    }

    @Test
    void singleItemHasExpectedNameFromProduct() {
        final String name = "product";
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(name, new Product(name, price).oneOf().name());
    }
}