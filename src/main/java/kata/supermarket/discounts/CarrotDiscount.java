package kata.supermarket.discounts;

import kata.supermarket.Item;
import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CarrotDiscount extends Discount {

    public CarrotDiscount(String productName) {
       super(productName);
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        BigDecimal weight = new BigDecimal("0.0");
        BigDecimal discountPerKilo = new BigDecimal("0.00");

        Optional<Item> first = items.stream().findFirst();
        if(first.isPresent()) {
            discountPerKilo = ((ItemByWeight)first.get()).getPricePerKilo().divide(new BigDecimal("2"));
        }
        for(Item item : items) {
            weight = weight.add(((ItemByWeight)item).getWeightInKilos());
        }

        BigDecimal numWholeKilos = weight.divideToIntegralValue(new BigDecimal("1.0"));

        return numWholeKilos.multiply(discountPerKilo);
    }
}
