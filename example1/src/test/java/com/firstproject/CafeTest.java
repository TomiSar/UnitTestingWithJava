package com.firstproject;

import com.firsproject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CafeTest {

    private static final int COFFEE_BEANS_NEEDED = 7;
    private static final int LATTE_MILK_NEEDED = 227;

    Cafe cafe = new Cafe();

    @BeforeEach
    public void setup() {
        cafe = new Cafe();
        System.out.println("Before each test init the Cafe value");
    }

    @Test
    public void canBrewExpressoAndCheckType() {
        // Arrange (Given)
        cafe.addBeansInStock(COFFEE_BEANS_NEEDED);

        // Act (When)
        Coffee espresso = cafe.brew(CoffeeType.Espresso);

        // Asserts (Then)
        assertEquals(COFFEE_BEANS_NEEDED,espresso.getBeans(), "Incorrect number of beans");
        assertEquals(0,espresso.getMilk(), "Incorrect amount of milk");
        assertEquals(CoffeeType.Espresso, espresso.getType(), "Incorrect CoffeeType");
    }

    @Test
    public void canBrewLatteAndCheckType() {
        // Arrange (Given)
        cafe.addBeansInStock(COFFEE_BEANS_NEEDED);
        cafe.addMilkInStock(LATTE_MILK_NEEDED);

        // Act (When)
        Coffee latte = cafe.brew(CoffeeType.Latte);

        // Asserts (Then)
        assertEquals(COFFEE_BEANS_NEEDED, latte.getBeans(), "Incorrect number of beans");
        assertEquals(LATTE_MILK_NEEDED,latte.getMilk(), "Incorrect amount of milk");
        assertEquals(CoffeeType.Latte, latte.getType(), "Incorrect CoffeeType");
    }

    @Test
    public void shouldUpdateTheStockAmountLevels() {
        // Arrange (Given)
        cafe.addBeansInStock(COFFEE_BEANS_NEEDED);

        // Act (When)
        cafe.brew(CoffeeType.Espresso);

        // Asserts (Then)
        assertEquals(0, cafe.getBeansInStock(), "Stock amount levels are not updating correctly");
    }

    @Test
    public void brewingExpressoRequiresBeans() {
        // Asserts (Then)
        Assertions.assertThrows(IllegalStateException.class, () -> {
            // Act (When)
            cafe.brew(CoffeeType.Espresso);
        });
    }

    @Test
    public void brewingLatteRequiresMilk() {
        // Asserts (Then)
        Assertions.assertThrows(IllegalStateException.class, () -> {
            // Act (When)
            cafe.brew(CoffeeType.Latte);
        }, "Incorrectly brewed Latte");
    }

    @Test
    public void mustRestockPositiveAmountOfBeans() {
        // Asserts (Then)
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Act (When)
            cafe.addBeansInStock(0);
        });
    }

    @Test
    public void mustRestockPositiveAmountOfMilk() {
        // Asserts (Then)
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Act (When)
            cafe.addMilkInStock(0);
        });
    }
}
