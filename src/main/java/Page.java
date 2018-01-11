import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public class Page {

    public Page() {    }


    private ArrayList<String> getFieldNames() {
        return new ArrayList<String>();
    }
    private String getField(String fieldname) {
        return getWebElement(getLocator(fieldname)).getText();
    }

    private WebElement getWebElement(By locator) {
        return null;
    }

    private By getLocator(String fieldname) {
        return new By.ByXPath("");

    }

    public Plan readActualDataToPlan() {


        return new Plan();
    }
}
