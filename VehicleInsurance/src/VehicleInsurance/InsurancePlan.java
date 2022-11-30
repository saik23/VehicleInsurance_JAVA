/**
 * InsurancePlan contains details pertaining to the plan including risks covered, premium, coverage, coverageCap details
 * This class can act as different types of insurances offered by the company based on the risks attribute.
 *
 */
package VehicleInsurance;

import java.util.*;

public class InsurancePlan {

    /**
     * Attributes for the InsurancePlan
     * planNumber: Used for searching a plan
     * risksCovered: Used to identify which risks are covered by the plan
     * premium, Coverage: premium, coverage as percentages for the plan.
     * coverageCap, deathCoverage: maximum coverage for the plan.
     */
    private final int planNumber;
    private final List<Risk> risksCovered;
    double premium;
    double coverage;
    double vehicleValue;
    double coverageCap;
    double deathCoverage;

    /**
     * Private Constructor to promote using the builder class for instantiation.
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
     * Creates a Builder Class object for the InsurancePlan class
     * @return an InsurancePlanBuilder object
     */
    public static InsurancePlanBuilder getBuilder() {
        return new InsurancePlanBuilder();
    }

    public static class InsurancePlanBuilder {
        /**
         * Contains same attributes as the base class to replicate the construction.
         */
        private int planNumber;
        private List<Risk> risksCovered;
        double premium;
        double coverage;
        double vehicleValue;
        double coverageCap;
        double deathCoverage;

        /**
         * Making the BuilderClass constructor private to prevent multiple instances.
         */
        private InsurancePlanBuilder() {
        }

        /**
         * Helper Build functions
         */
        public InsurancePlanBuilder setPlanNumber(int planNumber) {
            this.planNumber = planNumber;
            return this;
        }

        public InsurancePlanBuilder setPremium(double premium) {
            this.premium = premium;
            return this;
        }

        public InsurancePlanBuilder setCoverage(double coverage) {
            this.coverage = coverage;
            return this;
        }

        public InsurancePlanBuilder setVehicleValue(double vehicleValue) {
            this.vehicleValue = vehicleValue;
            return this;
        }

        public InsurancePlanBuilder setCoverageCap(double coverageCap) {
            this.coverageCap = coverageCap;
            return this;
        }

        public InsurancePlanBuilder setDeathCoverage(double deathCoverage) {
            this.deathCoverage = deathCoverage;
            return this;
        }

        public InsurancePlanBuilder setRisksCovered(ArrayList<Risk> risksCovered) {
            this.risksCovered = risksCovered;
            return this;
        }
        /**
         * Creates the Insurance Plan with default values here and returns the object.
         * @return InsurancePlan object with default initialization.
         */
        public InsurancePlan build() {
            return new InsurancePlan(this.planNumber, this.risksCovered, this.premium, this.coverage,
                    this.vehicleValue, this.coverageCap, this.deathCoverage);
        }
    }

    /**
     * Member functions of the class
     */
    @Override
    public String toString() {
        // TODO: Add list of risks covered to this returned string
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

    public int getPlanNumber() {
        return this.planNumber;
    }

    public double getPremium() {
        return this.premium;
    }

    public double getCoverage() {
        return this.coverage;
    }

    public double getCoverageCap() {
        return this.coverageCap;
    }

    public double getDeathCoverage() {
        return this.deathCoverage;
    }

    public double updateCoverageCap(double settledAmount) {
        this.coverageCap -= settledAmount;
        if(this.coverageCap < 0) {
            throw new IllegalArgumentException();
        }
        return this.coverageCap;
    }

    public double updateDeathCoverage() {
        this.deathCoverage = 0;
        return this.deathCoverage;
    }
}
