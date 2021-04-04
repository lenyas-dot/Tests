import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage
{
    private MobileElement firstField;
    private MobileElement secondField;
    private MobileElement resultField;
    private MobileElement addButton;
    private MobileElement subButton;
    private MobileElement divButton;
    private MobileElement mulButton;
    private MobileElement resetButton;

    private void setButtons(AndroidDriver driver)
    {
        firstField = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldLeft");
        secondField = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldRight");
        resultField = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/resultTextView");
        addButton = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/additionButton");
        subButton = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/subtractButton");
        divButton = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/divisionButton");
        mulButton = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/multiplicationButton");
        resetButton = (MobileElement) driver.findElementById("com.vbanthia.androidsampleapp:id/resetButton");
    }

    public CalculatorPage(AndroidDriver driver)
    {
        setButtons(driver);
    }

    public void SetFirstField(String number)
    {
        firstField.setValue(number);
    }
    public void SetSecondField(String number)
    {
        secondField.setValue(number);
    }
    public String GetFirstField()
    {
        return firstField.getText();
    }
    public String GetSecondField()
    {
        return secondField.getText();
    }
    public String GetResultField()
    {
        return resultField.getText();
    }
    public void SetResultField(String number)
    {
        resultField.setValue(number);
    }
    public void ClickAddButton()
    {
        addButton.click();
    }
    public void ClickSubButton()
    {
        subButton.click();
    }
    public void ClickMulButton()
    {
        mulButton.click();
    }
    public void ClickDivButton()
    {
        divButton.click();
    }
    public void ClickResetButton()
    {
        resetButton.click();
    }

}
