package se.kth.iv1350.possem3.integration;

import se.kth.iv1350.possem3.model.ItemWithQuantity;

import java.util.List;

/**
 * <code>ExtInvSys</code> is a placeholder for the actual external inventory system. In this application, <code>ExtInvSys</code>
 * will contain hardcoded inventory information, and will distribute it when called based on the item ID provided by the cashier.
 */

public class ExtInvSys {

    /**
     * <code>getItemInfo</code> returns an item DTO with information about the item with the entered item ID. For this
     * application, this information is hard coded.
     * @param itemID The ID of the item, provided by the cashier.
     * @return Returns an <code>ItemDTO</code> object.
     */

    public ItemDTO getItemInfo(int itemID){
        switch (itemID){
            case 11:
                return new ItemDTO(15,0.12, itemID, "One liter organic milk from Arla", "Milk");
            case 12:
                return new ItemDTO(19, 0.12, itemID, "One package of spaghetti", "Spaghetti");
            case 13:
                return new ItemDTO(20, 0.12, itemID, "GB Glace Sandwich ice cream", "Sandwich ice cream");
            default:
                return new ItemDTO(0, 0, itemID,"Item not found", "Unknown item");
        }
    }

    /**
     * <code>sendSaleInformation</code> sends sale information to the external inventory system. In this application, this
     * is not implemented more than adding a method representing that part.
     */

    public void sendSaleInformation(List<ItemWithQuantity> soldItems){

    }
}
