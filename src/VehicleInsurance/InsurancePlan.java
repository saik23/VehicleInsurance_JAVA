package VehicleInsurance;

import java.util.*;

/**
 * InsurancePlan contains details pertaining to the plan including risks covered, premium, coverage, coverageCap details
 * This class can act as different types of insurances offered by the company based on the risks attribute.
 */
public class InsurancePlan {

    /**
     * Attributes for the InsurancePlan.
     * planNumber: Used for searching a plan from the planRecord used by the company.
     * risksCovered: Used to identify which risks are covered by the plan
     * premium, coverage: premium and coverage as percentages for the plan.
     * coverageCap, deathCoverage: maximum coverage for the plan in case of any accident or fatality.
     */
    private final int planNumber;
    private final List<Risk> risksCovered;
    double premium;
    double coverage;
    double vehicleValue;
    double coverageCap;
    double deathCoverage;

    /**
     * Private Constructor -- promotes the use of the builder class for instantiation.
     */
    private InsurancePlan(int planNumber, List<Risk> risksCovered, double premium, double coverage,
                          double vehicleValue, double coverageCap, double deathCoverage) {
        this.planNumber = planNumber;
        this.risksCovered = risksCovered;
        this.premium = premium;
        this.coverage = coverage;
        this.vehicleValue = vehicleValue;
        this.coverageCap = coverageCap;
        this.deathCoverage = deathCoverage;
    }

    /**
     * Creates a Builder Class object for the InsurancePlan class.
     * @return an InsurancePlanBuilder object.
     */
    public static InsurancePlanBuilder getBuilder() {
        return new InsurancePlanBuilder();
    }

    /**
     * Builder class to be used for creating InsurancePlan objects.
     * Helps with individual parameter setting. Example of using BuilderPattern.
     */
    public static class InsurancePlanBuilder {
        /**
         * Contains same attributes as the base class to replicate the construction.
         * However, the final parameters from the base class are also listed as non-final attributes here.
         */
        private int planNumber;
        private List<Risk> risksCovered;
        double premium;
        double coverage;
        double vehicleValue;
        double coverageCap;
        double deathCoverage;

        /**
         * BuilderClass constructor is private to prevent multiple instances.
         */
        private InsurancePlanBuilder() {
        }

        /**
         * Helper builder class method for InsurancePlan object to set the plan Number.
         * @param planNumber: planNumber - key for the HashMap in the InsuranceCompany object
         * @return InsurancePlanBuilder object with modified planNumber.
         */
        public InsurancePlanBuilder setPlanNumber(int planNumber) {
            this.planNumber = planNumber;
            return this;
        }

        /**
         * Helper builder class method to set the premium value for the plan based on plan details from the company.
         * @param premium: premium percentage.
         * @return InsurancePlanBuilder object with modified premium value.
         */
        public InsurancePlanBuilder setPremium(double premium) {
            this.premium = premium;
            return this;
        }

        /**
         * Helper builder class method to set the coverage value for the plan based on plan details from the company.
         * @param coverage: coverage offered by the plan.
         * @return InsurancePlanBuilder object with modified coverage value.
         */
        public InsurancePlanBuilder setCoverage(double coverage) {
            this.coverage = coverage;
            return this;
        }

        /**
         * Helper builder class method to set the vehicle value for the vehicle being covered.
         * @param vehicleValue: current vehicle value as mentioned by the user.
         * @return InsurancePlanBuilder object with modified vehicle value.
         */
        public InsurancePlanBuilder setVehicleValue(double vehicleValue) {
            this.vehicleValue = vehicleValue;
            return this;
        }

        /**
         * Helper builder method to set the coverage cap for the current plan decided by the plan details from company.
         * @param coverageCap: plan coverage cap set by the company.
         * @return InsurancePlanBuilder object with modified coverage cap.
         */
        public InsurancePlanBuilder setCoverageCap(double coverageCap) {
            this.coverageCap = coverageCap;
            return this;
        }

        /**
         * Helper builder method to set the death coverage for the plan.
         * @param deathCoverage: Death coverage set by the company for the plan.
         * @return InsurancePlanBuilder object with modified death coverage value.
         */
        public InsurancePlanBuilder setDeathCoverage(double deathCoverage) {
            this.deathCoverage = deathCoverage;
            return this;
        }

        /**
         * Helper builder method to set the risks covered by the plan. Each plan covers a set of risks defined by the
         * company.
         * @param risksCovered: Risks covered by the insurance plan.
         * @return InsurancePlanBuilder object with updated risks covered by the plan.
         */
        public InsurancePlanBuilder setRisksCovered(ArrayList<Risk> risksCovered) {
            this.risksCovered = risksCovered;
            return this;
        }

        /**
         * Creates the Insurance Plan with default and modified values here and returns the object.
         * @return InsurancePlan object with correct initialization.
         */
        public InsurancePlan build() {
            return new InsurancePlan(this.planNumber, this.risksCovered, this.premium, this.coverage,
                    this.vehicleValue, this.coverageCap, this.deathCoverage);
        }
    }

    /**
     * Overriding the toString function to print only relevant information for the class.
     * @return String representing the relevant information for a plan.
     */
    @Override
    public String toString() {
        return String.format("""
                        Insurance Plan ID: %d
                        Premium: %f
                        Coverage: %f
                        Coverage Cap: %f
                        Death Coverage: %f
                        Risks Covered: %s
                        """, this.planNumber, this.premium*this.vehicleValue,
                this.coverage*vehicleValue, this.coverageCap, this.deathCoverage, this.risksCovered);
    }

    /**
     * Getter method for the planNumber.
     * @return planNumber - key for the planRecord used by the InsuranceCompany.
     */
    public int getPlanNumber() {
        return this.planNumber;
    }

    /**
     * Getter method for the premium value.
     * @return premium for the plan.
     */
    public double getPremium() {
        return this.premium;
    }

    /**
     * Getter method for the coverage value.
     * @return coverage for the plan.
     */
    public double getCoverage() {
        return this.coverage;
    }

    /**
     * Getter method for the coverage cap for the plan.
     * @return coverageCap for the plan.
     */
    public double getCoverageCap() {
        return this.coverageCap;
    }

    /**
     * Getter method for the deathCoverage for the plan.
     * @return deathCoverage for the plan.
     */
    public double getDeathCoverage() {
        return this.deathCoverage;
    }

    /**
     * Updates the coverageCap for the plan after each settlement connected to the plan.
     * Settlements can only be made against a plan when the cap is not exceeded.
     * @param settledAmount: amount to be substracted from the coverageCap.
     * @throws <code>IllegalArgumentException</code> when called with settledAmount > coverageCap
     * @return updated coverageCap.
     */
    public double updateCoverageCap(double settledAmount) throws IllegalArgumentException {
        this.coverageCap -= settledAmount;
        if(this.coverageCap < 0) {
            throw new IllegalArgumentException();
        }
        return this.coverageCap;
    }
}
