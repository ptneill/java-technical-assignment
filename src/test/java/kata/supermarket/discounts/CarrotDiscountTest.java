package kata.supermarket.discounts;

import kata.supermarket.Item;
import kata.supermarket.WeighedProduct;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarrotDiscountTest {
    /*
    £2 per 1kg of carrots
Weight: 500g -- Original price: £1 -- Expected discounted price: £1
Weight: 1kg -- Original price: £2 -- Expected discounted price: £1
Weight: 1.5kg -- Original price: £3 -- Expected discounted price: £2
Weight: 2kg -- Original price: £4 -- Expected discounted price: £2
     */
    WeighedProduct getCarrotProduct() {
        return new WeighedProduct("carrots", new BigDecimal("2.00"));
    }

    @Test
    void NoDiscountFor500grams() {
        WeighedProduct carrots = getCarrotProduct();

        final List<Item> items = new ArrayList<>();
        items.add(carrots.weighing(new BigDecimal("0.5")));

        final CarrotDiscount discount = new CarrotDiscount("carrots");
        assertEquals(new BigDecimal("0.00"), discount.calculateDiscount(items));
    }

    @Test
    void OnePoundForOneKilogram() {
        WeighedProduct carrots = getCarrotProduct();

        final List<Item> items = new ArrayList<>();
        items.add(carrots.weighing(new BigDecimal("1.0")));

        final CarrotDiscount discount = new CarrotDiscount("carrots");
        assertEquals(new BigDecimal("1.00"), discount.calculateDiscount(items));
    }

    @Test
    void TwoPoundForOneAndAHalfKilos() {
        WeighedProduct carrots = getCarrotProduct();

        final List<Item> items = new ArrayList<>();
        items.add(carrots.weighing(new BigDecimal("1.5")));

        final CarrotDiscount discount = new CarrotDiscount("carrots");
        assertEquals(new BigDecimal("1.00"), discount.calculateDiscount(items));
    }

    @Test
    void TwoPoundForTwoKilos() {
        WeighedProduct carrots = getCarrotProduct();

        final List<Item> items = new ArrayList<>();
        items.add(carrots.weighing(new BigDecimal("2.0")));

        final CarrotDiscount discount = new CarrotDiscount("carrots");
        assertEquals(new BigDecimal("2.00"), discount.calculateDiscount(items));
    }

    /*
    Weight: 1x 500g, 1x 1.7kg, 1x 2kg -- Original price: £8.40 -- Expected discounted price: £4.40
     */
    @Test
    void MultipleWeighedItems() {
        WeighedProduct carrots = getCarrotProduct();

        final List<Item> items = new ArrayList<>();
        items.add(carrots.weighing(new BigDecimal(".5")));
        items.add(carrots.weighing(new BigDecimal("1.7")));
        items.add(carrots.weighing(new BigDecimal("2.0")));

        final CarrotDiscount discount = new CarrotDiscount("carrots");
        assertEquals(new BigDecimal("4.00"), discount.calculateDiscount(items));
    }
}
