package se.kth.iv1350.possem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possem3.integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemOnReceiptTest {
    private ItemOnReceipt instanceToTest;
    private ItemWithQuantity itemWithQuantityTest;
    private ItemDTO itemInfoTest;

    @BeforeEach
    void setUp() {
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        itemWithQuantityTest = new ItemWithQuantity(itemInfoTest);
        instanceToTest = new ItemOnReceipt(itemWithQuantityTest);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
    }


    @Test
    void testCalculatePriceInclVATCalculatesCorrectly(){
        double itemInfoTestPrice = 15;
        double itemInfoTestVAT = 0.12;
        double correctPriceInclVAT = itemInfoTestPrice*(1 + itemInfoTestVAT);

        boolean expResult = true;
        boolean result = correctPriceInclVAT == instanceToTest.getItemPriceInclVAT();

        assertEquals(expResult, result, "The total price incl. VAT was calculated incorrectly.");

    }
}