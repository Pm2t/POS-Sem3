package se.kth.iv1350.possem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possem3.integration.ItemDTO;
import se.kth.iv1350.possem3.integration.ReceiptDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private ItemOnReceipt itemOnReceiptTest;
    private Receipt instanceToTest;
    private ReceiptDTO receiptDTOTest;
    private List<ItemOnReceipt> itemsOnReceiptTest;
    private ItemWithQuantity itemWithQuantityTest;
    private ItemDTO itemInfoTest;
    private LocalDateTime testTime;
    private DateTimeFormatter formatter;
    private String timeOfSale;

    @BeforeEach
    void setUp() {
        itemInfoTest = new ItemDTO(15,0.12, 11, "One liter organic milk from Arla", "Milk");
        itemWithQuantityTest = new ItemWithQuantity(itemInfoTest);
        itemOnReceiptTest = new ItemOnReceipt(itemWithQuantityTest);
        itemsOnReceiptTest = new ArrayList<>();
        itemsOnReceiptTest.add(itemOnReceiptTest);
        testTime = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        timeOfSale = testTime.format(formatter);
        receiptDTOTest = new ReceiptDTO(itemsOnReceiptTest, 16.8, 20, timeOfSale, 3.2);
        instanceToTest = new Receipt(receiptDTOTest);
    }

    @AfterEach
    void tearDown() {
        itemInfoTest = null;
        itemWithQuantityTest = null;
        itemOnReceiptTest = null;
        itemsOnReceiptTest = null;
        receiptDTOTest = null;
        instanceToTest = null;
        testTime = null;
        formatter = null;
        timeOfSale = null;
    }

    @Test
    void testGetBuiltReceiptBuildsReceiptWithCorrectInformation() {
        String testBuiltReceipt = instanceToTest.getBuiltReceipt();

        boolean expResult = true;
        boolean result = testBuiltReceipt.contains("Milk") && testBuiltReceipt.contains("16.80");

        assertEquals(expResult, result, "The receipt does not contain correct information.");
    }

    @Test
    void testCorrectTimeOfSale(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String timeOfSale = currentDateTime.format(formatter);

        String testBuiltReceipt = instanceToTest.getBuiltReceipt();

        boolean expResult = true;
        boolean result = testBuiltReceipt.contains(timeOfSale);

        assertEquals(expResult, result, "The time of sale was not set correctly.");
    }
}