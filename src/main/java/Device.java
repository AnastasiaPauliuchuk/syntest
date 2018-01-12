import java.util.List;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class Device {

    private String name;
    private boolean policeBased;
    private List<Policy> policies;
    private Policy policyInInitialPlan;
    private boolean hasSeveralPolicies;
    private String details;
    private boolean checkedInInitialPlan;

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", policeBased=" + policeBased +
                ", policies=" + policies +
                ", policyInInitialPlan=" + policyInInitialPlan +
                ", hasSeveralPolicies=" + hasSeveralPolicies +
                ", details='" + details + '\'' +
                ", checkedInInitialPlan=" + checkedInInitialPlan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Device device = (Device) o;

        if (policeBased != device.policeBased)
            return false;
        if (hasSeveralPolicies != device.hasSeveralPolicies)
            return false;
        if (checkedInInitialPlan != device.checkedInInitialPlan)
            return false;
        if (!name.equals(device.name))
            return false;
        if (policies != null ? !policies.equals(device.policies) : device.policies != null)
            return false;
        if (policyInInitialPlan != null ? !policyInInitialPlan.equals(device.policyInInitialPlan) : device.policyInInitialPlan != null)
            return false;
        return details != null ? details.equals(device.details) : device.details == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (policeBased ? 1 : 0);
        result = 31 * result + (policies != null ? policies.hashCode() : 0);
        result = 31 * result + (policyInInitialPlan != null ? policyInInitialPlan.hashCode() : 0);
        result = 31 * result + (hasSeveralPolicies ? 1 : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (checkedInInitialPlan ? 1 : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPoliceBased() {
        return policeBased;
    }

    public void setPoliceBased(boolean policeBased) {
        this.policeBased = policeBased;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public Policy getPolicyInInitialPlan() {
        return policyInInitialPlan;
    }

    public void setPolicyInInitialPlan(Policy policyInInitialPlan) {
        this.policyInInitialPlan = policyInInitialPlan;
    }

    public boolean isHasSeveralPolicies() {
        return hasSeveralPolicies;
    }

    public void setHasSeveralPolicies(boolean hasSeveralPolicies) {
        this.hasSeveralPolicies = hasSeveralPolicies;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isCheckedInInitialPlan() {
        return checkedInInitialPlan;
    }

    public void setCheckedInInitialPlan(boolean checkedInInitialPlan) {
        this.checkedInInitialPlan = checkedInInitialPlan;
    }

    public void setField(String fieldName, String value) {
        //do something to set field value by it's name and value to set
    }

    public boolean hasEqualFields(Device device) {


        if (policeBased != device.policeBased)
            return false;
        if (hasSeveralPolicies != device.hasSeveralPolicies)
            return false;
        if (checkedInInitialPlan != device.checkedInInitialPlan)
            return false;
        if (!name.equals(device.name))
            return false;

        if (policyInInitialPlan != null ? !policyInInitialPlan.equals(device.policyInInitialPlan) : device.policyInInitialPlan != null)
            return false;
        return details != null ? details.equals(device.details) : device.details == null;
    }
}
