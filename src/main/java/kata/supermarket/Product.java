package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final String productName;

    private final BigDecimal pricePerUnit;

    public Product(final String productName, final BigDecimal pricePerUnit) {
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
    }

    String productName() { return productName; }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
