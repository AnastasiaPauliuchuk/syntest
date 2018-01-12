import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class Page {

    public Page() {    }


    private ArrayList<String> getFieldNames() {

        //mock with empty
        return new ArrayList<String>();
    }

    private WebElement getField(String fieldname) {
        //mock with empty
        return getWebElement(getLocator(fieldname));
    }

    private WebElement getWebElement(By locator) {
        //mock with empty
        return null;
    }

    private By getLocator(String fieldname) {
        //construct fieldName based on parentElement and fieldName
        //mock with empty
        return new By.ByXPath("");
    }

    public Plan readActualDataToPlan(String actualType) {

        //parsing html, based on locators
        //read all policy objects
        Plan actualPlan = new Plan();
        actualPlan.setMixTraffic(getUiMixTraffic());
        Map<String,Device> deviceMap = new HashMap<>();

        List<WebElement> policyElementsList = getUiPolicies();
        for (WebElement policyElement : policyElementsList) {
            Policy policyInInitialPlan = new Policy();
            policyInInitialPlan.setCheckInitial(getUiCheckInitial());
            //read all devices objects
            List<WebElement> deviceElementsList = getUiDevices(policyElement);
            for (WebElement deviceElement : deviceElementsList) {
                Device device = new Device();
                device.setPolicyInInitialPlan(policyInInitialPlan);
                // parse deviceElement
                //get fields from html
                ArrayList<String> fields = getFieldNames();
                String deviceName = getField("name").getText();

                for(String fieldName : fields)
                {
                    device.setField(fieldName,getField(String.format("%1$s : %2$s",deviceElement.getText(),fieldName)).getText());
                }
                //if there is device with such fields found in the map just add current policy to the policies array
                if(deviceMap.containsKey(deviceName)) {
                    if (deviceMap.get(deviceName).hasEqualFields(device))
                        device.getPolicies().add(policyInInitialPlan);
                }
                else
                    deviceMap.put(deviceName,device);

                // add device to plan
                actualPlan.getDevices().addAll(deviceMap.values());
            }
        }
        // mock instead of parsing html, based on locators
       return MockPlanCreator.create(actualType);
    }

    private boolean getUiMixTraffic() {
        WebElement mixTrafficElement = getField("mixTraffic");
        return false;
    }

    private boolean getUiCheckInitial() {
        WebElement checkInitialElement = getField("checkInitial");
        return true;
    }


    private List<WebElement> getUiPolicies() {
        //mock with empty list
        return Collections.emptyList();
    }

    private List<WebElement> getUiDevices(WebElement policyElement) {
        //mock with empty list
        return Collections.emptyList();
    }

}
