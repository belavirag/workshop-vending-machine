package dev.belavirag.workshop.vendingmachine.utils;

public class CurrencyHelper {
    private static final int[] VALID_CURRENCY_VALUES = {
            1, 2, 5, 10, 20, 50, 100, 200, 500, 1000
    };

    public static boolean isValid(int amount) {
        for (int a : VALID_CURRENCY_VALUES) {
            if (a == amount) {
                return true;
            }
        }

        return false;
    }
}
