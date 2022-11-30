package VehicleInsurance;

/**
 * Premium Payment Class. Records the premium payment for a plan by the customer.
 */
public class Payment {

    /**
     * Attributes: paymentID, planID, premiumAmount, dateTime.
     */
    private int paymentID;
    private int planID;
    private double premiumAmount;
    private String dateTime;

    private String customerName;

    public Payment(String customerName, int paymentID, int planID, double premiumAmount, String dateTime) {
        this.customerName = customerName;
        this.paymentID = paymentID;
        this.planID = planID;
        this.premiumAmount = premiumAmount;
        this.dateTime = dateTime;
    }

    /**
     * Setter and getter methods.
     */
    public double getPremiumAmount() {
        return premiumAmount;
    }

    public int getPlanID() {
        return planID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "";
    }
}

