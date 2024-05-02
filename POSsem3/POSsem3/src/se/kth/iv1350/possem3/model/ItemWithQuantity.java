package se.kth.iv1350.possem3.model;

import se.kth.iv1350.possem3.integration.ItemDTO;

/**
 * <code>ItemWithQuantity</code> contains information about each item being sold including quantity.
 */

public class ItemWithQuantity {
    private final String itemName;
    private final double itemPrice;
    private final double itemVAT;
    private final int itemID;
    private int itemQuantity;

    /**
     * This constructor initializes the private variables with the provided values. Quantity is set to its starting value of 1.
     * @param itemInfo The DTO of the item being sold.
     */

    public ItemWithQuantity(ItemDTO itemInfo){
        this.itemName = itemInfo.getItemName();
        this.itemPrice = itemInfo.getItemPrice();
        this.itemVAT = itemInfo.getItemVAT();
        this.itemID = itemInfo.getItemID();
        itemQuantity = 1;
    }

    /**
     * <code>increaseQuantity</code> increases the quantity of an item when called.
     */

    public void increaseQuantity(){
        itemQuantity++;
    }

    /**
     * Getter method for the item name.
     * @return Returns the item name.
     */

    public String getItemName(){
        return itemName;
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
     * Getter method for the quantity of the same item.
     * @return Returns the quantity.
     */

    public int getItemQuantity(){
        return itemQuantity;
    }
}
