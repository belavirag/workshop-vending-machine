package dev.belavirag.workshop.vendingmachine;

import dev.belavirag.workshop.vendingmachine.data.ProductRegistry;
import dev.belavirag.workshop.vendingmachine.model.*;

public class Main {
    public static void main(String[] args) {
        ProductRegistry.registerProduct(new ChocolateBar(0, 20, "Chocolate Bar", ChocolateBarType.MARS));
        ProductRegistry.registerProduct(new Drink(1, 10, "Soft Drink", DrinkType.WATER));
        ProductRegistry.registerProduct(new JellyBean(2, 1, "Jellybean", JellyBeanType.SOUR_CHERRY));
    }
}