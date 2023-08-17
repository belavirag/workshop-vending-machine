package dev.belavirag.workshop.vendingmachine.data;

import dev.belavirag.workshop.vendingmachine.model.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductRegistry {
    private static Product[] products = new Product[0];

    public static void registerProduct(Product product) {
        Objects.requireNonNull(product, "product should not be null!");

        for (Product p : products) {
            if (p == product) {
                throw new IllegalArgumentException("product already exists!");
            }

            if (p.getId() == product.getId()) {
                throw new IllegalArgumentException("product with that id already exists!: " + p.getProductName());
            }
        }

        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
    }

    public static Product getProduct(int id) {
        return products[id];
    }

    public static Product[] getAllProducts() {
        return Arrays.copyOf(products, products.length);
    }
}
