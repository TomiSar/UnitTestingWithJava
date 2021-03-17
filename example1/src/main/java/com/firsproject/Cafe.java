package com.firsproject;

/* A coffee shop that can brew coffee and maintains an internal stock of beans and milk.*/
public final class Cafe {
    private int beansInStock = 0;
    private int milkInStock = 0;

    public Coffee brew(CoffeeType coffeeType) {
        return brew(coffeeType, 1);
    }

    public Coffee brew(CoffeeType coffeeType, int strength) {
        requirePositive(strength);

        int requiredBeans = coffeeType.getRequiredBeans() * strength;
        int requiredMilk = coffeeType.getRequiredMilk() * strength;
        if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
            throw new IllegalStateException("Not enough inventory in the Stock!!");
        }

        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;
        return new Coffee(coffeeType, requiredBeans, requiredMilk);
    }

    public void addBeansInStock(int beansAmount) {
        requirePositive(beansAmount);
        beansInStock += beansAmount;
    }

    public void addMilkInStock(int milkAmount) {
        requirePositive(milkAmount);
        milkInStock += milkAmount;
    }

    private void requirePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInStock() {
        return beansInStock;
    }

    public int getMilkInStock() {
        return milkInStock;
    }
}
