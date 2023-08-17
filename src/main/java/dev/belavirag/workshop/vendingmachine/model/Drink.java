package dev.belavirag.workshop.vendingmachine.model;
import java.util.Locale;

public class Drink extends Product {
    private DrinkType type;

    public Drink(int id, int price, String productName, DrinkType type) {
        super(id, price, productName);
        this.type = type;
    }

    @Override
    public String examine() {
        StringBuilder builder = new StringBuilder();

        builder.append("Popular drinks, following types are available: ");
        for (DrinkType types : DrinkType.values()) {
            builder.append(types.toString().replace("_", " ").toLowerCase(Locale.ROOT));
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 2); // remove last comma

        return builder.toString().trim();
    }

    @Override
    public String use() {
        return "Regular every-day sugary or carbonated beverage";
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }
}
