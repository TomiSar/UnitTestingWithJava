package com.firstproject;

import com.firsproject.Coffee;
import com.firsproject.CoffeeType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExampleTest {

    @Test
    public void mapShouldContainValue() {
        var values = Map.of("A", 1, "B", 2);
        assertThat(values, hasEntry("B", 2));
    }

    @Test
    public void listContainsNumbersOrderIrrelevant() {
        List<Integer> numbers = getNumbersFromList();
        assertThat(numbers, containsInAnyOrder(2, 4, 6, 8, 10));
    }

    private List<Integer> getNumbersFromList() {
        return Arrays.asList(10, 6, 4, 8, 2);
    }

    @Test
    public void properties() {
        Coffee coffee = new Coffee(CoffeeType.FilterCoffee, 10, 0);
        assertThat(coffee, hasProperty("beans", is(10)));
        assertThat(coffee, hasProperty("milk", is(0)));
//        assertEquals(10, coffee.getBeans());
//        assertEquals(0, coffee.getMilk());
    }

    @Test
    public void coffeeListContainsSingleAndMultipleValues() {
        var coffees = List.of(new Coffee(CoffeeType.Espresso, 7, 0),
                                           new Coffee(CoffeeType.FilterCoffee, 10, 0));
        assertThat(coffees, hasItem(hasProperty("beans", is(7))));

        assertThat(coffees, containsInAnyOrder(hasProperty("beans", is(10)),
                                     hasProperty("beans", is(7))));
    }
}
