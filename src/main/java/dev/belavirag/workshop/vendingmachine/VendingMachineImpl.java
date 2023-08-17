package dev.belavirag.workshop.vendingmachine;

import dev.belavirag.workshop.vendingmachine.data.ProductRegistry;
import dev.belavirag.workshop.vendingmachine.model.Product;
import dev.belavirag.workshop.vendingmachine.utils.CurrencyHelper;

import java.util.Arrays;

public class VendingMachineImpl implements VendingMachine {
    private Product[] products = new Product[0];
    private int depositPool;

    @Override
    public void addCurrency(int amount) {
        if (!CurrencyHelper.isValid(amount)) {
            throw new IllegalArgumentException("currency amount is invalid!");
        }

        depositPool += amount;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        //TODO: clone Product?
        Product p = ProductRegistry.getProduct(id);
        if (depositPool < p.getPrice()) {
            throw new IllegalArgumentException("balance is not enough!");
        }

        this.products = Arrays.copyOf(this.products, this.products.length + 1);
        this.products[this.products.length - 1] = p;
        this.depositPool -= p.getPrice();

        return p;
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }

    @Override
    public String getDescription(int id) {
        return ProductRegistry.getProduct(id).examine();
    }

    @Override
    public String[] getProducts() {
        String[] information = new String[this.products.length];

        for (int i = 0; i < this.products.length; i++) {
            information[i] = this.products[i].toString();
        }

        return information;
    }
}
