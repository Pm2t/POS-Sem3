package se.kth.iv1350.possem3.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possem3.integration.CreateExternalSys;
import se.kth.iv1350.possem3.integration.ItemDTO;
import se.kth.iv1350.possem3.integration.Printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller instanceToTest;
    private ItemDTO itemInfoTest;

    private final ByteArrayOutputStream outputFromTestToArray = new ByteArrayOutputStream();
    private final PrintStream standOut = System.out;


    private final int correctItemIDTest = 11;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputFromTestToArray));
        Printer printerTest = new Printer();
        CreateExternalSys creatorTest = new CreateExternalSys();
        instanceToTest = new Controller(creatorTest, printerTest);
        instanceToTest.startNewSale();
    }

    @AfterEach
    void tearDown() {
        System.setOut(standOut);
        instanceToTest = null;
    }

    @Test
    void testStartNewSaleCreatesAnSaleObject() {

        boolean expResult = true;
        boolean result = instanceToTest.getTotalPrice() == 0;

        assertEquals(expResult, result, "A sale object was not created.");
    }

    @Test
    void testCorrectInformationFromEnterItem() {
        itemInfoTest = instanceToTest.enterItem(correctItemIDTest);

        boolean expResult = true;
        boolean result = itemInfoTest.getItemName() == "Milk";

        assertEquals(expResult, result, "The correct item name was not returned.");
    }

    @Test
    void testEnterItemWithWrongItemID(){

        int wrongItemIDTest = 1234;
        itemInfoTest = instanceToTest.enterItem(wrongItemIDTest);

        boolean expResult = true;
        boolean result = itemInfoTest.getItemName().equals("Unknown item");

        assertEquals(expResult, result, "The method did not return correct item information.");
    }

    @Test
    void testCurrentSaleUpdatesCorrectlyInEnterItem(){
        itemInfoTest = instanceToTest.enterItem(correctItemIDTest);

        boolean expResult = true;
        double correctTotalPrice = itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT());
        boolean result = correctTotalPrice == instanceToTest.getTotalPrice();

        assertEquals(expResult, result, "Sale was not updated correctly.");
    }

    @Test
    void testEndSaleGivesTheTotalCost(){
        itemInfoTest = instanceToTest.enterItem(correctItemIDTest);
        itemInfoTest = instanceToTest.enterItem(correctItemIDTest);

        double totalPriceTest = instanceToTest.endSale();

        boolean expResult = true;
        boolean result = totalPriceTest == itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT())*2;

        assertEquals(expResult, result, "The correct total cost was not returned.");
    }

    @Test
    void testPaymentReturnsCorrectChangeAmount(){
        itemInfoTest = instanceToTest.enterItem(correctItemIDTest);

        double paidAmountTest = 100;
        double correctChange = paidAmountTest - itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT());

        boolean expResult = true;
        boolean result = instanceToTest.payment(paidAmountTest) == correctChange;

        assertEquals(expResult, result, "The change amount returned from payment is incorrect.");
    }
}