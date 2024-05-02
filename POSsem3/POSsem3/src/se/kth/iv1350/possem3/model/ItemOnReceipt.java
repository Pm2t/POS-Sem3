package se.kth.iv1350.possem3.model;


/**
 * <code>ItemOnReceipt</code> adjusts the information from <code>ItemWithQuantity</code> to be more suited for the receipt.
 */

public class ItemOnReceipt {
    private final String itemName;
    private final int itemQuantity;
    private final double itemPriceInclVAT;
    private final double totalPriceOfAnItemInclVAT;

    /**
     * This constructor initializes the values for the private variables.
     */

    public ItemOnReceipt(ItemWithQuantity soldItem){
        itemName = soldItem.getItemName();
        itemQuantity = soldItem.getItemQuantity();
        itemPriceInclVAT = calculatePriceInclVAT(soldItem);
        totalPriceOfAnItemInclVAT = calculatePriceInclVAT(soldItem)*soldItem.getItemQuantity();

    }

    private double calculatePriceInclVAT(ItemWithQuantity soldItem){
        return soldItem.getItemPrice()*(1 + soldItem.getItemVAT());
    }

    /**
     * Getter method for the item name.
     * @return Returns the item name.
     */

    public String getItemName(){
        return itemName;
    }

     /**
     * Getter method for the quantity of the item.
     * @return Returns the quantity.
     */

    public int getItemQuantity(){
        return itemQuantity;
    }

    /**
     * Getter method for the price incl. VAT.
     * @return Returns the price incl. VAT.
     */

    public double getItemPriceInclVAT(){
        return itemPriceInclVAT;
    }

    /**
     * Getter method for the total price of and item incl. VAT. Which is the total price of an item incl. VAT times the
     * quantity of that item.
     * @return Returns the total price of an item incl. VAT.
     */

    public double getTotalPriceOfAnItemInclVAT(){
        return totalPriceOfAnItemInclVAT;
    }







}
