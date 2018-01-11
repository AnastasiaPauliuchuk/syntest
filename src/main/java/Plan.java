import java.util.HashSet;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class Plan {

    private boolean mixTraffic;
    private HashSet<Device> devices;
    private HashSet<Policy> policies;


    public Plan() {
        super();
    }
    public Plan(boolean mixTraffic, HashSet<Device> devices, HashSet<Policy> policies) {
        this.mixTraffic = mixTraffic;
        this.devices = devices;
        this.policies = policies;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
