package se.kth.iv1350.possem3.controller;

import se.kth.iv1350.possem3.integration.*;
import se.kth.iv1350.possem3.model.Register;
import se.kth.iv1350.possem3.model.Sale;

/**
 * <code>Controller</code> handles method calls from <code>View</code> to packages <code>model</code>
 * and <code>integration</code>.
 */

public class Controller {
    private final Printer printer;
    private final ExtAccSys extAccSys;
    private final ExtInvSys extInvSys;
    private final Register register;
    private Sale currentSale;

    /**
     * This constructor initializes the <code>controller</code>> with specific objects of the external accounting and
     * inventory systems. It also initializes the controller with an object of <code>Printer</code>.
     * @param creator This is an object of the class <code>CreateExternalSys</code> which is used to get
     *                objects of the external systems.
     * @param printer This is the object of the <code>Printer</code> class.
     */

    public Controller(CreateExternalSys creator, Printer printer){
        extAccSys = creator.getExtAccSys();
        extInvSys = creator.getExtInvSys();
        this.printer = printer;
        register = new Register();
    }

    /**
     * <code>startNewSale</code> initializes the sale, it creates a new <code>Sale</code> object.
     */

    public void startNewSale(){
        currentSale = new Sale();
    }

    /**
     * <code>enterItem</code> gets an item DTO from <code>ExtInvSys</code> and passes it to <code>updateSale</code>
     * in <code>Sale</code>. It also returns the item DTO <code>itemInfo</code> with information about the item
     * to <code>View</code> so it can be displayed.
     * @param itemID The ID of the item, provided by the cashier.
     * @return Returns the item DTO.
     */

    public ItemDTO enterItem(int itemID){
        ItemDTO itemInfo = extInvSys.getItemInfo(itemID);
        currentSale.updateSale(itemInfo);

        return itemInfo;
    }

    /**
     * Getter method for the total cost of the sale.
     * @return Returns the total cost of the sale.
     */

    public double getTotalPrice(){
        return currentSale.getTotalPrice();
    }

    /**
     * <code>endSale</code> is called when the sale is ended. It provides information needed after the sale. For now, it is
     * the total cost of the sale.
     * @return Returns total cost of sale.
     */

    public double endSale(){
        return currentSale.getTotalPrice();
    }

    /**
     * <code>payment</code> handles the actions needed when the customer pays. That includes updating the external systems
     * with the relevant information, updating the amount in the register and print a receipt.
     * @param paidAmount The paid amount, provided by the cashier.
     * @Return Returns the change amount to give the customer.
     */

    public double payment(double paidAmount){
        sendSaleInfoToExternalSystems();

        register.enterAmountPaid(paidAmount);

        double amountGivenInChange = currentSale.startReceipt(printer, paidAmount);

        register.subtractChangeAmount(amountGivenInChange);

        return amountGivenInChange;
    }

    private void sendSaleInfoToExternalSystems(){
        extAccSys.sendSaleInformation(currentSale.getSoldItems());
        extInvSys.sendSaleInformation(currentSale.getSoldItems());
    }
}
