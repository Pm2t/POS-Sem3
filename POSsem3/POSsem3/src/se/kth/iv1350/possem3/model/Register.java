package se.kth.iv1350.possem3.model;

/**
 * <code>Register</code> handles the register, for this application, its amount.
 */

public class Register {
    private double amountInRegister;

    /**
     * <code>enterAmountPaid</code> updates the balance in the register with the amount provided.
     * @param amountPaid The amount the customer paid, provided by the cashier.
     */

    public void enterAmountPaid(double amountPaid){
        amountInRegister += amountPaid;
    }

    /**
     * <code>subtractChangeAmount</code> subtracts the amount that is given in change to the customer from the amount present
     * in the register.
     * @param amountGivenInChange The amount given back to the customer in change.
     */

    public void subtractChangeAmount(double amountGivenInChange){
        amountInRegister -= amountGivenInChange;
    }

}
