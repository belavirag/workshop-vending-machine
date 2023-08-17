package dev.belavirag.workshop.vendingmachine.model;

public abstract class Product {
    private int id;
    private double price;
    private String productName;

    public Product(int id, int price, String productName) {
        this.id = id;
        this.price = price;
        this.productName = productName;
    }

    public abstract String examine();

    public abstract String use();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }
}
