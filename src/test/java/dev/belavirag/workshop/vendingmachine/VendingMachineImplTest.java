package dev.belavirag.workshop.vendingmachine;

import dev.belavirag.workshop.vendingmachine.data.ProductRegistry;
import dev.belavirag.workshop.vendingmachine.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {
    VendingMachineImpl machine;

    @BeforeAll
    static void registerProducts() {
        // 1 product is enough for testing
        ProductRegistry.registerProduct(new ChocolateBar(0, 20, "Chocolate Bar", ChocolateBarType.MARS));
    }

    @BeforeEach
    void setUp() {
        machine = new VendingMachineImpl();
    }

    @Test
    void addCurrency() {
        machine.addCurrency(1);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
           machine.addCurrency(0);
        });

        assertEquals(thrown.getMessage(), "currency amount is invalid!");
    }

    @Test
    void request() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            machine.request(0);
        });

        int amt = 50;
        assertEquals(thrown.getMessage(), "balance is not enough!");
        machine.addCurrency(50);
        Product p = machine.request(0);
        assertEquals(p.getId(), 0);
        assertEquals(machine.getBalance(), amt - p.getPrice());
    }

    @Test
    void endSession() {
        int amt = 50;
        machine.addCurrency(amt);
        assertEquals(machine.endSession(), amt);
        assertEquals(machine.getBalance(), 0);
    }

    @Test
    void getDescription() {
        assertEquals(machine.getDescription(0), "Regular chocolate bar, following types are available: mars, snickers, twix");
    }

    @Test
    void getProducts() {
        machine.addCurrency(20);
        Product requestedProduct = machine.request(0);
        String[] whatWasRequested = machine.getProducts();

        assertEquals(whatWasRequested[0], "Product{id=0, price=20.0, productName='Chocolate Bar'}");
        assertEquals(requestedProduct.toString(), whatWasRequested[0]);
    }
}