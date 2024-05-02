package se.kth.iv1350.possem3.integration;

/**
 * <code>ItemDTO</code> contains contains information about each item and is used to transfer that information.
 */

public class ItemDTO {
    private final double itemPrice;
    private final double itemVAT;
    private final int itemID;
    private final String itemDescription;
    private final String itemName;

    /**
     * This constructor initializes the private variables with provided values.
     * @param itemPrice Item price provided by the external inventory system.
     * @param itemVAT   Item VAT rate provided by the external inventory system.
     * @param itemID    Item ID provided by the cashier.
     * @param itemDescription Item description provided by the external inventory system.
     * @param itemName  Item name provided by the external inventory system.
     */


    public ItemDTO(double itemPrice, double itemVAT, int itemID, String itemDescription, String itemName){
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
        this.itemID = itemID;
        this.itemDescription = itemDescription;
        this.itemName = itemName;
    }

    /**
     * Getter method for the item price.
     * @return Returns the item price.
     */

    public double getItemPrice(){
        return itemPrice;
    }

    /**
     * Getter method for the item VAT rate.
     * @return Returns the item VAT rate.
     */

    public double getItemVAT(){
        return itemVAT;
    }

    /**
     * Getter method for the item ID.
     * @return Returns the item ID.
     */

    public int getItemID(){
        return itemID;
    }

    /**
     * Getter method for the item description.
     * @return Returns the item description.
     */

    public String getItemDescription(){
        return itemDescription;
    }

    /**
     * Getter method for the item name.
     * @return Returns the item name.
     */

    public String getItemName(){
        return itemName;
    }



}
