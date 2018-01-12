import java.util.Arrays;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class MockPlanCreator {
    public static final String DEVICE_1_POLICY_NAME = "FireFlow SG - 15 instances";
    public static final String DEVICE_2_POLICY_NAME = "FireFlow SG -13 instances";
    public static final String INITIAL_PLAN_POLICY_NAME_1 = "AWS_automation | sa-east-1 | vpc-c7c74aa3 | FireFlow SG - 15 instances";
    public static final String INITIAL_PLAN_POLICY_NAME_2 = "AWS_automation | sa-east-1 | vpc-c7c74aa3 | FireFlow SG -13 instances";
    public static final boolean NOT_MIXED_TRAFFIC = false;
    public static final boolean CHECKED_IN_INITIAL_PLAN = true;
    public static final boolean HAS_SEVERAL_POLICIES = true;
    public static final boolean POLICY_BASED = true;
    public static final String DEVICE_NAME_1 = "FireFlow_SG_-_15_instances/FireFlow_SG_-13_instances/acl-d631ebb2";
    public static final String DEVICE_NAME_2 = "FireFlow_SG_-13_instances/acl-d631ebb2";
    public static final String DETAILS_BLOCKED = "Blocked";

    public static Policy createInitialPlanPolicy(String policyName){
        Policy initialPlanPolicy = new Policy();
        initialPlanPolicy.setCheckInitial(CHECKED_IN_INITIAL_PLAN);
        initialPlanPolicy.setName(INITIAL_PLAN_POLICY_NAME_1);
        return initialPlanPolicy;
    }

    private static Plan createDefaultPlan() {

        Policy initialPlanPolicy = createInitialPlanPolicy(INITIAL_PLAN_POLICY_NAME_1);

        Policy failInitialPlanPolicy = new Policy();
        failInitialPlanPolicy.setCheckInitial(CHECKED_IN_INITIAL_PLAN);
        failInitialPlanPolicy.setName(INITIAL_PLAN_POLICY_NAME_2);

        Policy device1Policy = new Policy();
        device1Policy.setCheckInitial(true);
        device1Policy.setName(DEVICE_1_POLICY_NAME);

        Policy device2Policy = new Policy();
        device2Policy.setCheckInitial(CHECKED_IN_INITIAL_PLAN);
        device2Policy.setName(DEVICE_2_POLICY_NAME);

        Device device1 = new Device();
        device1.setName(DEVICE_NAME_1);
        device1.setPoliceBased(POLICY_BASED);
        device1.setPolicies(Arrays.asList(device1Policy));
        device1.setPolicyInInitialPlan(initialPlanPolicy);
        device1.setHasSeveralPolicies(HAS_SEVERAL_POLICIES);
        device1.setCheckedInInitialPlan(CHECKED_IN_INITIAL_PLAN);
        device1.setDetails(DETAILS_BLOCKED);

        Device device2 = new Device();
        device2.setName(DEVICE_NAME_2);
        device2.setPoliceBased(POLICY_BASED);
        device2.setPolicies(Arrays.asList(device2Policy));
        device2.setPolicyInInitialPlan(initialPlanPolicy);
        device1.setHasSeveralPolicies(HAS_SEVERAL_POLICIES);
        device2.setCheckedInInitialPlan(CHECKED_IN_INITIAL_PLAN);
        device2.setDetails(DETAILS_BLOCKED);

        Plan defaultPlan = new Plan();
        defaultPlan.setMixTraffic(NOT_MIXED_TRAFFIC);
        defaultPlan.setDevices(Arrays.asList(device1, device2));
        return defaultPlan;
    }

    public static Plan create(String dataType) {
        Plan result = null;
        switch (dataType) {
            case "expected":
            case "actualPass":
                result = createDefaultPlan();
                break;
            case "actualFail": {
                result = createDefaultPlan();
                result.getDevices().get(0).getPolicyInInitialPlan().setName(INITIAL_PLAN_POLICY_NAME_2);
            }
        }
        return result;
    }
}
