package VehicleInsurance;

import java.util.*;

/**
 * Class to create claims against a vehicle and a policy attached to it.
 * User creates a claim against a risk involving third parties (not always).
 * Settlements can be called on each incident in the claim separately.
 */
public class Claim {

    /**
     * Attributes:
     * claimID: ID for the claim to be tracked by the system.
     * paymentsDue: List of payments to be paid by the company for each incident.
     * settlements: List of Settlement IDs for each incident.
     * justification: Risk that covers the incident. (One of: ThirdParty, VehicleDamage, VehicleAssistance, PersonalInjury, Death)
     * destinations: List of Strings denoting the receiver of the payment by the company from a settlement.
     * dateTime: Date and time of the claim.
     * settled: True if the claim is settled. Default is false.
     */
    private int claimID;
    private String vehicleID;

    private List<Double> paymentsDue;
    private List<String> destinations;
    private List<Integer> settlements;
    private List<String> justifications;

    private String dateTime;

    private Boolean settled;

    /**
     * private Constructor to be used only by the Builder pattern for instance creation.
     */
    public Claim(int claimID, String vehicleRegistrationNumber, String dateTime) {
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
     * Getter method for the claim ID
     * @return claim ID for the claim. Acts as key for the claimRecord kept by the company.
     */
    public int getClaimID() {
        return this.claimID;
    }

    /**
     * Getter method for the settled boolean attribute.
     * @return true if the claim is settled, false otherwise.
     */
    public Boolean getSettled() {return this.settled;}

    /**
     * Method to mark the claim as settled.
     */
    public void markSettled() { this.settled = true;}

    /**
     * Getter method for the list of payments due.
     * @return paymentsDue
     */
    public List<Double> getPaymentsDue() {
        return this.paymentsDue;
    }

    /**
     * update method for the paymentsDue attribute.
     * @param paymentDue new payment to be made by the insurance company.
     */
    public void updatePaymentsDue(double paymentDue) {
        this.paymentsDue.add(paymentDue);
    }

    /**
     * Getter method for justifications for all the incidents in the claim.
     * @return List of justifications for the incidents in the claim.
     */
    public List<String> getJustification() {
        return this.justifications;
    }

    /**
     * Update method for the justifications.
     * @param justification new justification to be added to the list
     */
    public void updateJustifications(String justification) {
        this.justifications.add(justification);
    }

    /**
     * Getter method for the destination of the settlement.
     * @return list of destinations for the claim.
     */
    public List<String> getDestinations() { return this.destinations; }

    /**
     * update destination for the settlement.
     * @param destination new destination for the payment corresponding to an incident.
     */
    public void updateDestinations(String destination) {
        this.destinations.add(destination);
    }

    /**
     * Getter method for the settlements.
     * @return list of settlement IDs corresponding to the claim incidents.
     */
    public List<Integer> getSettlements() {
        return this.settlements;
    }

    /**
     * update method for the settlements.
     * @param settlementID new settlement ID to be added.
     */
    public void updateSettlements(int settlementID) {
        this.settlements.add(settlementID);
    }

    /**
     * Getter method for the date and time of the claim creation.
     * @return String with date and time: MM-DD-YYYY HH:MM:SS
     */
    public String getDateTime() { return dateTime; }

    /**
     * Getter method for the vehicle registrationNumber.
     * @return vehicleRegistration number included in the claim.
     */
    public String getVehicle() { return this.vehicleID; }

    /**
     * toString overridden function to include only relevant information.
     * @return String containing relevant information on the claim.
     */
    @Override
    public String toString() {
        return String.format("""
                Claim ID: %d
                Vehicle Registration Number: %s
                Compensation amounts: %s
                Third Parties: %s
                Date and Time:%s
                Settled: %b
                 """,
                this.getClaimID(), this.getVehicle(), this.getPaymentsDue(),
                this.getDestinations(), this.getDateTime(), this.getSettled());
    }
}
