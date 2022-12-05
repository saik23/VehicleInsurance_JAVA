package VehicleInsurance;

/**
 * Premium Payment Class. Records the premium payment for a plan by the customer.
 */
public class Payment {

    /**
     * Attributes for the class:
     * paymentID: payment ID to keep track of all payments by the company.
     * planID: ID of the plan for the premium.
     * premiumAmount: premium amount paid by the customer.
     * dateTime: Date and Time of premium payment.
     */
    private final int paymentID;
    private final int planID;
    private final double premiumAmount;
    private final String dateTime;

    private final String customerName;

    public Payment(String customerName, int paymentID, int planID, double premiumAmount, String dateTime) {
        this.customerName = customerName;
        this.paymentID = paymentID;
        this.planID = planID;
        this.premiumAmount = premiumAmount;
        this.dateTime = dateTime;
    }

    /**
     * Getter method for the premium amount paid.
     * @return premium amount from the payment.
     */
    public double getPremiumAmount() {
        return this.premiumAmount;
    }

    /**
     * Getter method for the date and time of the transaction.
     * @return date and time of the payment for record.
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Getter method for the payment ID
     * @return Payment ID
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * Getter method for the plan ID.
     * @return plan ID
     */
    public int getPlanID() {
        return this.planID;
    }

    /**
     * Getter method for the customer name.
     * @return Customer name.
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * toString function overridden to print only relevant information from the class.
     * @return Relevant information of the class returned as String.
     */
    @Override
    public String toString() {
        return String.format("""
                paymentID: %d
                premium: %f
                planID: %d
                customer Name: %s,
                date and time: %s
                """, this.getPaymentID(), this.getPremiumAmount(), this.getPlanID(),
                this.getCustomerName(), this.getDateTime());
    }
}

