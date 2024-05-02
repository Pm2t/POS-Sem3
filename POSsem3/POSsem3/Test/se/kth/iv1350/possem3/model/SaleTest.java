package se.kth.iv1350.possem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possem3.integration.ItemDTO;
import se.kth.iv1350.possem3.integration.Printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale instanceToTest;
    private ItemDTO itemInfoTest;

    private final ByteArrayOutputStream outputFromTestToArray = new ByteArrayOutputStream();
    private final PrintStream standOut = System.out;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputFromTestToArray));
        instanceToTest = new Sale();
    }

    @AfterEach
    void tearDown() {
        System.setOut(standOut);
        instanceToTest = null;
    }

    @Test
    void testTotalPriceStartsAtZero(){
        boolean expResult = true;
        boolean result = instanceToTest.getTotalPrice() == 0;

        assertEquals(expResult, result, "The starting total price was not set to 0");
    }

    @Test
    void testTotalPriceIncreaseInUpdateSale(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        instanceToTest.updateSale(itemInfoTest);

        double correctTotalPrice = itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT());

        boolean expResult = true;
        boolean result = correctTotalPrice == instanceToTest.getTotalPrice();

        assertEquals(expResult, result, "Total price was not increased correctly.");
    }

    @Test
    void testTotalPriceDoesNotIncreaseInUpdateSale(){
        ItemDTO itemInfoNotValidTest = new ItemDTO(15, 0.12, 11, "One liter organic milk from Arla", "Unknown item");

        instanceToTest.updateSale(itemInfoNotValidTest);

        double correctTotalPrice = 0;

        boolean expResult = true;
        boolean result = instanceToTest.getTotalPrice() == correctTotalPrice;

        assertEquals(expResult, result, "Total price increased with an invalid item.");
    }

    @Test
    void testItemDoesAlreadyExistInUpdateSale(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");

        instanceToTest.updateSale(itemInfoTest);
        instanceToTest.updateSale(itemInfoTest);

        boolean expResult = true;
        boolean result = instanceToTest.getTotalPrice() == itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT())*2;

        assertEquals(expResult, result, "The same item was not added again.");
    }

    @Test
    void testItemDoesNotAlreadyExistInUpdateSale(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        ItemDTO otherItemInfoTest = new ItemDTO(10, 0.12, 15, "Other One liter organic milk from Arla", "Other Milk");

        instanceToTest.updateSale(itemInfoTest);
        instanceToTest.updateSale(otherItemInfoTest);

        double correctTotalPrice = itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT())+ otherItemInfoTest.getItemPrice()
                *(1 + otherItemInfoTest.getItemVAT());

        boolean expResult = true;
        boolean result = correctTotalPrice == instanceToTest.getTotalPrice();

        assertEquals(expResult, result, "The new item was not added.");
    }

    @Test
    void testCorrectChangeInStartReceipt(){
        testChangeInStartReceipt(100);
    }

    @Test
    void testStartReceiptWithMAX_VALUE(){
        testChangeInStartReceipt(Double.MAX_VALUE);
    }

    private void testChangeInStartReceipt(double paidAmountTest){
        Printer printerTest = new Printer();
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");

        instanceToTest.updateSale(itemInfoTest);

        double changeTest = instanceToTest.startReceipt(printerTest, paidAmountTest);
        double correctChange = paidAmountTest - itemInfoTest.getItemPrice()*(1 + itemInfoTest.getItemVAT());

        boolean expResult = true;
        boolean result = changeTest == correctChange;

        assertEquals(expResult, result, "The change was not correct.");
    }

    @Test
    void testItemBeingAddedToSoldItemsListInUpdateSale(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        instanceToTest.updateSale(itemInfoTest);

        int itemIDInSoldItemsList = instanceToTest.getSoldItems().getFirst().getItemID();

        boolean expResult = true;
        boolean result = itemIDInSoldItemsList == itemInfoTest.getItemID();

        assertEquals(expResult, result, "The item was not added to the soldItems list.");
    }

    @Test
    void testItemDoesAlreadyExistAndIncreasesQuantityUpdateSale(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        instanceToTest.updateSale(itemInfoTest);
        instanceToTest.updateSale(itemInfoTest);

        int correctItemQuantity = 2;
        int quantityOfItemInSoldItemsList = instanceToTest.getSoldItems().getFirst().getItemQuantity();

        boolean expResult = true;
        boolean result = correctItemQuantity == quantityOfItemInSoldItemsList;

        assertEquals(expResult, result, "The quantity of the item was not increased correctly.");
    }

    @Test
    void testItemAlreadyExistOnlyIncreasesQuantityIfTrue(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        instanceToTest.updateSale(itemInfoTest);
        instanceToTest.updateSale(itemInfoTest);

        int correctQuantityOfElementsInSoldItemsList = 1;
        int quantityOfElementsInSoldItemsList = instanceToTest.getSoldItems().size();

        boolean expResult = true;
        boolean result = correctQuantityOfElementsInSoldItemsList == quantityOfElementsInSoldItemsList;

        assertEquals(expResult, result, "The same item was added to soldItems list when it should not have been.");

    }

    @Test
    void testItemBeingAddedIfNotAlreadyExist(){
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        ItemDTO otherItemInfoTest = new ItemDTO(20,0.12, 10, "Other one liter organic milk from Arla", "Other milk");

        instanceToTest.updateSale(itemInfoTest);
        instanceToTest.updateSale(otherItemInfoTest);

        int otherItemIDInSoldItemsList = instanceToTest.getSoldItems().get(1).getItemID();
        int otherItemID = otherItemInfoTest.getItemID();

        boolean expResult = true;
        boolean result = otherItemIDInSoldItemsList == otherItemID;

        assertEquals(expResult, result);
    }
}