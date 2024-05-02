package se.kth.iv1350.possem3.integration;

import se.kth.iv1350.possem3.model.ItemOnReceipt;
import java.util.List;

/**
 * <code>ReceiptDTO</code> contains information about the sale that are going on the receipt. <code>ReceiptDTO</code>
 * is used to transfer that information.
 */

public class ReceiptDTO {
    private final List<ItemOnReceipt> itemsOnReceipt;
    private final double totalPrice;
    private final double paidAmount;
    private final String timeOfSale;
    private final double change;

    /**
     * This constructor initializes the private variables with the provided values.
     * @param itemsOnReceipt List of items that will go on the receipt.
     * @param totalPrice The total cost of the sale.
     * @param paidAmount The amount paid by the customer.
     * @param timeOfSale The time of sale.
     */

    public ReceiptDTO(List<ItemOnReceipt> itemsOnReceipt, double totalPrice, double paidAmount, String timeOfSale, double change){
        this.itemsOnReceipt = itemsOnReceipt;
        this.totalPrice = totalPrice;
        this.paidAmount = paidAmount;
        this.timeOfSale = timeOfSale;
        this.change = change;
    }

    /**
     * Getter method for the list with every item that goes on the receipt.
     * @return Returns the list.
     */

    public List<ItemOnReceipt> getItemsOnReceipt(){
        return itemsOnReceipt;
    }

    /**
     * Getter method for the total price.
     * @return Returns the total price.
     */

    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * Getter method for the paid amount.
     * @return Returns the paid amount.
     */

    public double getPaidAmount(){
        return paidAmount;
    }

    /**
     * Getter method for the time of sale.
     * @return Returns the time of sale.
     */

    public String getTimeOfSale(){
        return timeOfSale;
    }

    /**
     * Getter method for the change.
     * @return Returns the change.
     */

    public double getChange(){
        return change;
    }


}
