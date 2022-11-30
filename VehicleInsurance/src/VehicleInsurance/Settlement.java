package VehicleInsurance;

import java.util.*;

/**
 * Settlement class that takes in a claim, checks if settlement is possible, makes the payment to third party,
 * updates the plan details for the vehicle.
 */
public class Settlement {

    /**
     * Attributes: claimID, paymentDue, vehicle
     */
    private int settlementID;
    private int claimID;
    private double paymentDue;
    private String vehicleID;
    private Boolean rejected;

    private String justification;
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
     * Member functions: setter getter methods.
     */

    public int getSettlementID() {
        return this.settlementID;
    }

    public double getPaymentDue() {
        return this.paymentDue;
    }

    public int getClaimID() {
        return this.claimID;
    }

    public String getVehicleID() {
        return this.vehicleID;
    }

    public String getJustification() {
        return this.justification;
    }
    public Boolean getRejected() {
        return this.rejected;
    }

    /**
     * Hack to find the plan that allows this coverage ->
     * We allow two types of plans - 1. A plan that covers a single type of risk, 2. An allRisk plan.
     * For a given policy if it is composed of multiple plans -
     *      it is composed of multiple individual risk covering plans.
     * Then we can match the index of the justification to the plan.
     * If the policy contains an AllRisk plan then the index of justification either matches or
     * exceeds the size of plans.size().
     * Based on this we can decide the index of the plan.
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
            if(policy.getRisksCovered().contains(this.getJustification())) {
                int planIndex = policy.getRisksCovered().indexOf(this.getJustification());
                if(planIndex > policy.getPlans().size()) {
                    planIndex = 0;
                }
                return policy.getPlans().get(planIndex);
            }
        }
        return -1;
    }

    /**
     * Calls verify, if true makes payment to third party, updates plan details, updates vehicle details.
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

    @Override
    public String toString() {
        return String.format("Settlement ID: %d\nClaim ID: %d\nRejected: %b\nPayment: %f\nVehicle ID: %s",
                this.getSettlementID(),
                this.getClaimID(),
                this.getRejected(),
                this.getPaymentDue(),
                this.getVehicleID());
    }
}
