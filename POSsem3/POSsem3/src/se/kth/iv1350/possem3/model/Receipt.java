package se.kth.iv1350.possem3.model;

import se.kth.iv1350.possem3.integration.ReceiptDTO;

import java.util.List;
import java.util.Locale;

/**
 * <code>Receipt</code> creates a receipt that can be printed.
 */

public class Receipt {
    private final String builtReceipt;

    /**
     * This constructor creates the receipt when called.
     * @param receiptDTO The information needed on the receipt.
     */

    public Receipt(ReceiptDTO receiptDTO){
        builtReceipt = buildReceipt(receiptDTO);
    }

    private String buildReceipt(ReceiptDTO receiptDTO){
        StringBuilder builder = new StringBuilder("\n** Receipt **");

        builder.append("\nTime of sale: ").append(receiptDTO.getTimeOfSale());
        builder.append("\n\n");
        addItemsToReceipt(receiptDTO, builder);
        builder.append("\nTotal: ").append(receiptDTO.getTotalPrice()).append(" SEK");
        builder.append("\nPaid amount: ").append(receiptDTO.getPaidAmount()).append(" SEK");
        builder.append("\nChange: ").append(receiptDTO.getChange()).append(" SEK");
        builder.append("\n** End of receipt **");

        return builder.toString();

    }

    private void addItemsToReceipt(ReceiptDTO receiptDTO, StringBuilder builder){
        List<ItemOnReceipt> itemsOnReceipt = receiptDTO.getItemsOnReceipt();

        String format = "%-25s %2d x %5.2f SEK      %6.2f SEK\n";

        for (ItemOnReceipt itemOnReceipt : itemsOnReceipt) {
            builder.append(String.format(Locale.US, format, itemOnReceipt.getItemName(), itemOnReceipt.getItemQuantity(),
                    itemOnReceipt.getItemPriceInclVAT(), itemOnReceipt.getTotalPriceOfAnItemInclVAT()));

        }
    }

    /**
     * Getter method for the build receipt.
     * @return Returns the built receipt.
     */

    public String getBuiltReceipt(){
        return builtReceipt;
    }
}
