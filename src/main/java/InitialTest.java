import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class InitialTest {

    private String propertiesFilename = "expected.JSON";


    @BeforeTest
    public void setUp() {
        ResourceJSONDataReader propReader = new ResourceJSONDataReader(propertiesFilename);
    }
    @Test
    public void runTest() {

        Page initialPage = openInitalPlanPage();
        Plan actualPlan = initialPage.readActualDataToPlan();
        Plan expectedPlan = readExpectedDataToPlan();
        Assert.assertEquals(actualPlan, expectedPlan);


    }

    private Page openInitalPlanPage() {
        return new Page();
    }

    private Plan readExpectedDataToPlan() {
        return new Plan();
    }

    private Plan readActualDataToPlan() {
        return new Plan();
    }
}
