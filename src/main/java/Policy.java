/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class Policy {

    private String name;
    private boolean checkInitial;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Policy policy = (Policy) o;

        if (checkInitial != policy.checkInitial)
            return false;
        return name.equals(policy.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (checkInitial ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "name='" + name + '\'' +
                ", checkInitial=" + checkInitial +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckInitial() {
        return checkInitial;
    }

    public void setCheckInitial(boolean checkInitial) {
        this.checkInitial = checkInitial;
    }
}
