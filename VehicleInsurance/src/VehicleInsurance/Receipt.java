package VehicleInsurance;

/**
 * Receipt class to store all the receipt information for payments.
 */
public class Receipt {
    /**
     * Attributes: ID, payee, payer, amount, dateTime.
     */
    private int receiptID;
    private int paymentID;
    private String payee;
    private String payer;
    private String dateTime;

    private double amountPaid;
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

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getDateTime() {return this.dateTime;}

    public void setPayee(String payee) {
        this.payee = payee;
    }
    public String getPayee() {return this.payee;}

    public void setPayer(String payer) {
        this.payer = payer;
    }
    public String getPayer() {return this.payer;}

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
    public int getPaymentID() {return this.paymentID;}

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }
    public int getReceiptID() {return this.receiptID; }

    public double getAmountPaid() {return this.amountPaid;}
    @Override
    public String toString() {
        return String.format("ReceiptID: %d\nPaymentID: %d\namount: %f\nPaid By: %s\nPaid To: %s\nDate Time: %s",
        this.getReceiptID(), this.getPaymentID(), this.getAmountPaid(),
                this.getPayer(), this.getPayee(), this.getDateTime());
    }

}
