package VehicleInsurance;

/**
 * Receipt class to store all the receipt information for payments.
 */
public class Receipt {

    /**
     * Attributes:
     * receiptID: Stores the receipt ID
     * payee: Payee name
     * payer: Payer name
     * amount: Amount paid
     * dateTime: Date and time of the transaction.
     */
    private final int receiptID;
    private final int paymentID;
    private final String payee;
    private final String payer;
    private final String dateTime;

    private final double amountPaid;
    /**
     * Builder class to be used for the instance creation.
     */
    public Receipt(int receiptID, int paymentID, String payee, String payer, String dateTime, double amountPaid) {
        this.receiptID = receiptID;
        this.paymentID = paymentID;
        this.payee = payee;
        this.payer = payer;
        this.dateTime = dateTime;
        this.amountPaid = amountPaid;
    }

    /**
     * Getter method for the date and time
     * @return date and time of the transaction.
     */
    public String getDateTime() {return this.dateTime;}

    /**
     * Getter method for the payee name.
     * @return payee name.
     */
    public String getPayee() {return this.payee;}

    /**
     * Getter method for the payer name.
     * @return payer name.
     */
    public String getPayer() {return this.payer;}

    /**
     * Getter method for the paymentID
     * @return paymentID
     */
    public int getPaymentID() {return this.paymentID;}

    /**
     * Getter method for the receipt ID
     * @return receipt ID
     */
    public int getReceiptID() {return this.receiptID; }

    /**
     * Getter method for the amount paid.
     * @return Amount paid in the transaction.
     */
    public double getAmountPaid() {return this.amountPaid;}

    /**
     * toString method overridden to include relevant information.
     * @return String with relevant attributes.
     */
    @Override
    public String toString() {
        return String.format("""
        ReceiptID: %d
        PaymentID: %d
        amount: %f
        Paid By: %s
        Paid To: %s
        Date Time: %s
        """,
        this.getReceiptID(), this.getPaymentID(), this.getAmountPaid(),
                this.getPayer(), this.getPayee(), this.getDateTime());
    }
}
