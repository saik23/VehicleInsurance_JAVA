package VehicleInsurance;

import java.util.*;

/**
 * Settlement class that takes in a claim, checks if settlement is possible, makes the payment to third party,
 * updates the plan details for the vehicle.
 */
public class Settlement {

    /**
     * Class attributes
     * settlement ID: ID of the settlement, used as key for the settlementRecord kept by the insuranceCompany,
     * claimID : ID of the claim that is being settled,
     * paymentDue : due amount for the settlement,
     * vehicle : registration number of the vehicle in question for the claim-settlement process,
     * rejected: boolean variable for the state of the settlement. true if settlement is rejected, false otherwise.
     * justification: Risk that current settlement is based on.
     */
    private final int settlementID;
    private final int claimID;
    private final double paymentDue;
    private final String vehicleID;

    private Boolean rejected;
    private final String justification;

    /**
     * Constructor for the class.
     */
    public Settlement(int settlementID, int claimID, double paymentDue, String justification, String vehicleID) {
        this.settlementID = settlementID;
        this.claimID = claimID;
        this.paymentDue = paymentDue;
        this.vehicleID = vehicleID;
        this.justification = justification;
        this.rejected = false;
    }

    /**
     * Getter method for the settlement ID.
     * @return settlement ID
     */
    public int getSettlementID() {
        return this.settlementID;
    }

    /**
     * Getter method for the payment due to settle.
     * @return due amount.
     */
    public double getPaymentDue() {
        return this.paymentDue;
    }

    /**
     * Getter method for the claimID relating to the settlement.
     * @return claimID
     */
    public int getClaimID() {
        return this.claimID;
    }

    /**
     * Getter method for the vehicle registration number.
     * @return registration number.
     */
    public String getVehicleID() {
        return this.vehicleID;
    }

    /**
     * Getter method for the settlement's justification.
     * @return justification/Risk for the current settlement.
     */
    public String getJustification() {
        return this.justification;
    }

    /**
     * Setter method for the rejected attribute.
     * A settlement is rejected if no plan covers it or if the coverage cap is exceeded.
     */
    public void markRejected() {
        this.rejected = true;
    }

    /**
     * Getter method for the rejected boolean variable.
     * @return true if the settlement is rejected. False otherwise.
     */
    public Boolean getRejected() {
        return this.rejected;
    }

    /**
     * If a risk is covered by a policy then we can return the plan index from the policy.
     * Else we return -1 after checking all the policies kept by the vehicle.
     *
     * @param vehicle: Vehicle Object for the claim/settlement process.
     * @return int: planID of the plan that covers the risk for the current vehicle. Returns -1 if the
     * no policy covers the current risk.
     */
    protected int verifyClaim(Vehicle vehicle){
        // Check if the vehicle is protected against the risk / justification.
        // If yes, then check the caps on the planCoverageCap for that particular plan.
        // If yes, proceed to settle.
        List<InsurancePolicy> policies = vehicle.getPolicy();

        for(InsurancePolicy policy:policies) {
            if(policy.getRisksCovered().contains(Risk.valueOf(this.getJustification()))) {
                // Restricting each policy to include a single plan. Hence, if risk is covered by the policy,
                // we can return the plan from this policy
                return policy.getPlans().get(0);
            }
        }
        return -1;
    }

    /**
     * Calls verify, if true makes payment to third party, updates plan details, updates vehicle details.
     * Exits after marking rejected if false.
     * @param plan InsurancePlan covering the current settlement's risk
     * @return true if settlement done, false if settlement is rejected.
     */
    public Boolean settle(InsurancePlan plan) {
        // Settle the claim against the plan here.
        if(plan.getCoverageCap() < this.getPaymentDue()) {
            this.rejected = true;
            return false;
        }

        plan.updateCoverageCap(this.getPaymentDue());
        this.rejected = false;
        return true;
    }

    /**
     * Overriding the toString method to include only relevant information for a settlement.
     * @return
     */
    @Override
    public String toString() {
        return String.format("""
                Settlement ID: %d
                Claim ID: %d
                Rejected: %b
                Payment: %f
                Vehicle ID: %s
                """, this.getSettlementID(), this.getClaimID(), this.getRejected(), this.getPaymentDue(),
                this.getVehicleID());
    }
}
