import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class InitialTest {

    public static final String ACTUAL_PASS = "actualPass";
    public static final String ACTUAL_FAIL = "actualFail";
    public static final String EXPECTED = "expected";

    @DataProvider(name = "actualType")
    public static Object[][] actualTypes() {
        return new String[][] {{ACTUAL_PASS}, {ACTUAL_FAIL}};
    }


    @Test(dataProvider = "actualType")
    public void runTest(String actualType) {

        Page initialPage = openInitalPlanPage();
        Plan actualPlan = initialPage.readActualDataToPlan(actualType);
        Plan expectedPlan = readExpectedDataToPlan();
        Assert.assertEquals(actualPlan, expectedPlan);
    }

    private Page openInitalPlanPage() {
        return new Page();
    }

    private Plan readExpectedDataToPlan() {
        //JSON string expected - read from file or another way
        return (Plan) readJsonToClass("expectedJson",Plan.class.getName());
    }

    private Object readJsonToClass(String json, String className) {
        try {
            if(className.equals(Plan.class.getName())) {

                // mock  instead of the json parsing to a plan
                return MockPlanCreator.create(EXPECTED);
            }
            else {
                // parse to another classes
                Object obj = Class.forName(className).newInstance();
                return obj;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       return null;
    }

}
