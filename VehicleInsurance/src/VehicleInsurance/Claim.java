package VehicleInsurance;

import java.util.*;

/**
 * Claim class: User creates a claim against a risk involving third parties(not always).
 * Attributes: claimID, paymentDue, settlementsToBeDone, justifications, policyList.
 */
public class Claim {

    /**
     * Attributes: claimID, paymentDue, settlements, justification, policies
     */
    private int claimID;
    private List<Double> paymentsDue;
    private List<String> destinations;

    private List<Integer> settlements;
    private List<String> justifications;
    //private List<String> damagedInventory;
    private String vehicleID;
    private String dateTime;

    private Boolean settled;
    /**
     * private Constructor to aid Builder pattern for instance creation.
     */
    public Claim(int claimID, String vehicleRegistrationNumber, String dateTime) {//, List<String> damagedInventory) {
        this.claimID = claimID;
        this.vehicleID = vehicleRegistrationNumber;
        this.dateTime = dateTime;
        this.settlements = new ArrayList<>();
        this.justifications = new ArrayList<>();
        this.paymentsDue = new ArrayList<>();
        this.destinations = new ArrayList<>();
        this.settled = false;
    }

    /**
     * Member functions: setters and getters
     */
    public int getClaimID() {
        return this.claimID;
    }
    public Boolean getSettled() {return this.settled;}
    public void markSettled() { this.settled = true;}

    public List<Double> getPaymentsDue() {
        return this.paymentsDue;
    }
    public void updatePaymentsDue(double paymentDue) {
        this.paymentsDue.add(paymentDue);
    }

    public List<String> getJustification() {
        return this.justifications;
    }
    public void updateJustifications(String justification) {
        this.justifications.add(justification);
    }

    public List<String> getDestinations() { return this.destinations; }
    public void updateDestinations(String destination) {
        this.destinations.add(destination);
    }

    public List<Integer> getSettlements() {
        return this.settlements;
    }
    public void updateSettlements(int settlementID) {
        this.settlements.add(settlementID);
    }

    //public List<String> getDamagedInventory() { return damagedInventory; }

    public String getDateTime() { return dateTime; }

    public void createSettlement(){}

    public String getVehicle() { return this.vehicleID; }

    @Override
    public String toString() {
        return String.format("Claim ID: %d\nVehicle Registration Number: %s\n" +
                "Compensation amounts: %s\nThird Parties: %s\nDate and Time:%s, Settled: %b",
                this.getClaimID(),
                this.getVehicle(),
                this.getPaymentsDue(),
                this.getDestinations(),
                this.getDateTime(),
                this.getSettled());
    }
}
