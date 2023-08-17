package dev.belavirag.workshop.vendingmachine;

import dev.belavirag.workshop.vendingmachine.model.Product;

public interface VendingMachine {
    void addCurrency(int amount);

    int getBalance();

    Product request(int id);

    int endSession();

    String getDescription(int id);

    String[] getProducts();
}
