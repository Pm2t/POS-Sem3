package se.kth.iv1350.possem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtInvSysTest {
    private ExtInvSys instanceToTest;

    @BeforeEach
    void setUp() {
        instanceToTest = new ExtInvSys();
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
    }

    @Test
    void testGetItemInfoWithValidItemID() {
        int validItemID = 11;
        ItemDTO itemInfoTest = instanceToTest.getItemInfo(validItemID);

        boolean expResult = true;
        boolean result = itemInfoTest.getItemName().equals("Milk");

        assertEquals(expResult, result, "The method getItemInfo returned wrong item info.");
    }

    @Test
    void testGetItemInfoWithInvalidID(){
        int invalidItemID = 99;
        ItemDTO itemInfoTest = instanceToTest.getItemInfo(invalidItemID);

        boolean expResult = true;
        boolean result = itemInfoTest.getItemName().equals("Unknown item");

        assertEquals(expResult, result, "The method getItemInfo returned wrong item info.");
    }
}