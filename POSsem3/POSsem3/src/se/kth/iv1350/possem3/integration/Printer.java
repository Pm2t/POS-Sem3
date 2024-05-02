package se.kth.iv1350.possem3.integration;

import se.kth.iv1350.possem3.model.Receipt;

/**
 * <code>Printer</code> is a placeholder for a real printer, it is used to print the receipt to the console.
 */

public class Printer {

    /**
     * <code>printReceipt</code> prints the receipt provided to the console.
     * @param receipt The receipt of the sale.
     */

    public void printReceipt(Receipt receipt){
        System.out.println(receipt.getBuiltReceipt());
    }
}
