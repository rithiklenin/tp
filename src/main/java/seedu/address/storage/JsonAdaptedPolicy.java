package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import seedu.address.model.policy.Policy;
import seedu.address.model.policy.PolicyType;
import seedu.address.model.policy.LifePolicy;
import seedu.address.model.policy.HealthPolicy;
import seedu.address.model.policy.EducationPolicy;

/**
 * Jackson-friendly version of {@link Policy}.
 */
@JsonTypeName("policy")
public class JsonAdaptedPolicy {
    private final PolicyType type;
    private final double premiumAmount;
    private final double coverageAmount;
    private final String expiryDate; // Assuming you want to include expiryDate as well

    /**
     * Constructs a {@code JsonAdaptedPolicy} with the given policy details.
     */
    @JsonCreator
    public JsonAdaptedPolicy(
            @JsonProperty("type") PolicyType type,
            @JsonProperty("premiumAmount") double premiumAmount,
            @JsonProperty("coverageAmount") double coverageAmount,
            @JsonProperty("expiryDate") String expiryDate) { // Adding expiryDate
        this.type = type;
        this.premiumAmount = premiumAmount;
        this.coverageAmount = coverageAmount;
        this.expiryDate = expiryDate; // Initialize expiryDate
    }

    /**
     * Converts this Jackson-friendly adapted policy object into the model's {@code Policy} object.
     *
     * @throws IllegalArgumentException if the policy type is unknown.
     */
    public Policy toModelType() {
        switch (type) {
        case LIFE:
            return new LifePolicy(premiumAmount, coverageAmount, expiryDate); // Add expiryDate
        case HEALTH:
            return new HealthPolicy(premiumAmount, coverageAmount, expiryDate); // Add expiryDate
        case EDUCATION:
            return new EducationPolicy(premiumAmount, coverageAmount, expiryDate); // Add expiryDate
        default:
            throw new IllegalArgumentException("Unknown policy type: " + type);
        }
    }

    // Getters for the fields, if needed
    public PolicyType getType() {
        return type;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public String getExpiryDate() { // Getter for expiryDate
        return expiryDate;
    }
}
