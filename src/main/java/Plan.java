import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class Plan {

    private boolean mixTraffic;
    private List<Device> devices = new ArrayList<>();


    public Plan() {
        super();
    }
    public Plan(boolean mixTraffic, List<Device> devices, Set<Policy> policies) {
        this.mixTraffic = mixTraffic;
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Plan plan = (Plan) o;

        if (mixTraffic != plan.mixTraffic)
            return false;
        if (devices != null ? !devices.equals(plan.devices) : plan.devices != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (mixTraffic ? 1 : 0);
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "mixTraffic=" + mixTraffic +
                ", devices=" + devices +
                '}';
    }

    public boolean isMixTraffic() {
        return mixTraffic;
    }

    public void setMixTraffic(boolean mixTraffic) {
        this.mixTraffic = mixTraffic;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}
