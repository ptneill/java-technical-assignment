package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {

    private final String productName;

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final String productName, final BigDecimal pricePerKilo) {
        this.productName = productName;
        this.pricePerKilo = pricePerKilo;
    }

    String productName() { return productName; }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
