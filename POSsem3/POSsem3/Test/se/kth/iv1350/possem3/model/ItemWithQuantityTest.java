package se.kth.iv1350.possem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possem3.integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemWithQuantityTest {
    private ItemWithQuantity instanceToTest;
    private ItemDTO itemInfoTest;

    @BeforeEach
    void setUp() {
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        instanceToTest = new ItemWithQuantity(itemInfoTest);
    }

    @AfterEach
    void tearDown() {

        instanceToTest = null;
    }

    @Test
    void testIncreaseQuantityIncreasesQuantity(){
        instanceToTest.increaseQuantity();

        boolean expResult = true;
        boolean result = instanceToTest.getItemQuantity() == 2;

        assertEquals(expResult, result, "The method increaseQuantity did not increase the quantity correctly.");
    }
}