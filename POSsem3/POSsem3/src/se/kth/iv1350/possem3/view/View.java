package se.kth.iv1350.possem3.view;

import se.kth.iv1350.possem3.controller.Controller;
import se.kth.iv1350.possem3.integration.ItemDTO;
import java.util.Locale;

/**
 * <code>View</code> handles interactions with the user. This class is a placeholder for the user interface.
 */

public class View {
    private final Controller controller;

    /**
     * This constructor initializes the <code>view</code> with an object of <code>Controller</code>.
     * @param controller This is the object this class initializes with.
     */

    public View(Controller controller){
        this.controller = controller;
    }

    /**
     * <code>simulateApplication</code> calls the methods in controller to simulate a run of this application
     * as it is intended in real use.
     */

    public void simulateApplication(){
        controller.startNewSale();
        System.out.println("A new sale has been started");

        ItemDTO itemInfo = controller.enterItem(11);
        double totalPrice = controller.getTotalPrice();

        itemDisplay(itemInfo, totalPrice);

        itemInfo = controller.enterItem(11);
        totalPrice = controller.getTotalPrice();

        itemDisplay(itemInfo, totalPrice);

        itemInfo = controller.enterItem(13);
        totalPrice = controller.getTotalPrice();

        itemDisplay(itemInfo, totalPrice);

        totalPrice = controller.endSale();
        System.out.println("\nEnd sale: ");
        System.out.printf(Locale.US,"Total cost (incl VAT): %.2f", totalPrice);
        System.out.println(" SEK");

        double amountPaid = 100;
        System.out.println("\nCustomer pays: " + amountPaid + " SEK.");

        System.out.println("\nSale information sent to accounting and inventory system.");
        System.out.println("Inventory system updates inventory quantity of the items sold.");
        System.out.println("Balance in register is updated.");

        double amountChange = controller.payment(amountPaid);

        System.out.println("\nChange to give the customer: " + amountChange + " SEK");
    }

    private void itemDisplay(ItemDTO itemInfo, double totalPrice){

        System.out.println("\nAdd 1 item with item id: " + itemInfo.getItemID());
        System.out.println("Item ID: " + itemInfo.getItemID());
        System.out.println("Item name: " + itemInfo.getItemName());
        System.out.printf(Locale.US,"Item price: %.2f", itemInfo.getItemPrice());
        System.out.println(" SEK");
        System.out.printf(Locale.US,"Item VAT: %.0f", itemInfo.getItemVAT()*100);
        System.out.println("%");
        System.out.println("Item description: " + itemInfo.getItemDescription());

        System.out.printf(Locale.US, "Total cost (incl VAT): %.2f", totalPrice);
        System.out.println(" SEK");
    }
}
