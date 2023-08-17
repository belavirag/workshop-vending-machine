package dev.belavirag.workshop.vendingmachine.model;

import java.util.Locale;

public class ChocolateBar extends Product {
    private ChocolateBarType type;

    public ChocolateBar(int id, int price, String productName, ChocolateBarType type) {
        super(id, price, productName);
        this.type = type;
    }

    @Override
    public String examine() {
        StringBuilder builder = new StringBuilder();

        builder.append("Regular chocolate bar, following types are available: ");
        for (ChocolateBarType types : ChocolateBarType.values()) {
            builder.append(types.toString().replace("_", " ").toLowerCase(Locale.ROOT));
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 2); // remove last comma

        return builder.toString().trim();
    }

    @Override
    public String use() {
        return "Popular chocolate bar across the world";
    }

    public ChocolateBarType getType() {
        return type;
    }

    public void setType(ChocolateBarType type) {
        this.type = type;
    }


}
