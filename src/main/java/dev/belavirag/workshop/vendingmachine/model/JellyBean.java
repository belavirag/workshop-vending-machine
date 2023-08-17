package dev.belavirag.workshop.vendingmachine.model;

import java.util.Locale;

public class JellyBean extends Product {
    private JellyBeanType type;

    public JellyBean(int id, int price, String productName, JellyBeanType type) {
        super(id, price, productName);
        this.type = type;
    }

    @Override
    public String examine() {
        StringBuilder builder = new StringBuilder();

        builder.append("Shiny, sweet jelly beans. The following types are available: ");
        for (ChocolateBarType types : ChocolateBarType.values()) {
            builder.append(types.toString().replace("_", " ").toLowerCase(Locale.ROOT));
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 2); // remove last comma

        return builder.toString().trim();
    }

    @Override
    public String use() {
        return "Different types of jelly beans in various colors.";
    }

    public JellyBeanType getType() {
        return type;
    }

    public void setType(JellyBeanType type) {
        this.type = type;
    }
}
