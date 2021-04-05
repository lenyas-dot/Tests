import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {


    private CalculatorPage calcPage;
    private AndroidDriver driver;

    @BeforeSuite()
    private void initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "pixel");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp");
        capabilities.setCapability("appActivity", "com.vbanthia.androidsampleapp.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        calcPage = new CalculatorPage(driver);
    }




    @Test(priority = 1)
    private void testResetButton() {
        calcPage.SetFirstField("5");
        calcPage.SetSecondField("5");

        calcPage.ClickResetButton();

        Assert.assertEquals(calcPage.GetFirstField(), "");
        Assert.assertEquals(calcPage.GetSecondField(), "");

    }


    //testing integer numbers
    @Test(priority = 2)
    private void testAdditionTwoPositiveNumbers() {
        calcPage.SetFirstField("5");                                                                                                                       ;
        calcPage.SetSecondField("2");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "5.00 + 2.00 = 7.00", "Result should be 7");

    }
    @Test(priority = 3)
    private void testAdditionTwoNegativeNumbers() {
        calcPage.SetFirstField("-5");                                                                                                                       ;
        calcPage.SetSecondField("-2");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "-5.00 + -2.00 = -7.00", "Result should be -7");

    }
    @Test(priority = 4)
    private void testAdditionTwoZeros() {
        calcPage.SetFirstField("0");                                                                                                                       ;
        calcPage.SetSecondField("0");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "0.00 + 0.00 = 0.00", "Result should be 0");

    }

    @Test(priority = 5)
    private void testSubtractionTwoPositiveNumbers() {
        calcPage.SetFirstField("5");                                                                                                                       ;
        calcPage.SetSecondField("2");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "5.00 - 2.00 = 3.00", "Result should be 3");

    }
    @Test(priority = 6)
    private void testSubtractionTwoNegativeNumbers() {
        calcPage.SetFirstField("-5");                                                                                                                       ;
        calcPage.SetSecondField("-2");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "-5.00 - -2.00 = -3.00", "Result should be -3");

    }
    @Test(priority = 7)
    private void testSubtractionTwoZeros() {
        calcPage.SetFirstField("0");                                                                                                                       ;
        calcPage.SetSecondField("0");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "0.00 - 0.00 = 0.00", "Result should be 0");

    }

    @Test(priority = 8)
    private void testMultiplyTwoPositiveNumbers() {
        calcPage.SetFirstField("5");                                                                                                                       ;
        calcPage.SetSecondField("2");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "5.00 * 2.00 = 10.00", "Result should be 10");

    }
    @Test(priority = 9)
    private void testMultiplyTwoNegativeNumbers() {
        calcPage.SetFirstField("-5");                                                                                                                       ;
        calcPage.SetSecondField("-2");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "-5.00 * -2.00 = 10.00", "Result should be 10");

    }
    @Test(priority = 10)
    private void testMultiplyTwoDifferentNumbers() {
        calcPage.SetFirstField("-5");                                                                                                                       ;
        calcPage.SetSecondField("2");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "-5.00 * 2.00 = -10.00", "Result should be -10");

    }
    @Test(priority = 11)
    private void testMultiplyTwoZeros() {
        calcPage.SetFirstField("0");                                                                                                                       ;
        calcPage.SetSecondField("0");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "0.00 * 0.00 = 0.00", "Result should be 0");

    }

    @Test(priority = 12)
    private void testDivTwoPositiveNumbers()
    {
        calcPage.SetFirstField("6");
        calcPage.SetSecondField("2");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "6.00 / 2.00 = 3.00", "Result should be 3");

    }
    @Test(priority = 13)
    private void testDivTwoNegativeNumbers()
    {
        calcPage.SetFirstField("-6");
        calcPage.SetSecondField("-2");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "-6.00 / -2.00 = 3.00", "Result should be 3");

    }
    @Test(priority = 14)
    private void testDivTwoDifferentNumbers()
    {
        calcPage.SetFirstField("-6");
        calcPage.SetSecondField("2");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "-6.00 / 2.00 = -3.00", "Result should be -3");

    }
    @Test(priority = 15)
    private void testDivisionZeroByZero()
    {
        calcPage.SetFirstField("0");
        calcPage.SetSecondField("0");
        calcPage.ClickDivButton();
        Assert.assertEquals(calcPage.GetResultField(), "0.00 / 0.00 = NaN", "Result should be NaN");
    }
    @Test(priority = 16)
    private void testDivisionByZero()
    {
        calcPage.SetFirstField("5");
        calcPage.SetSecondField("0");
        calcPage.ClickDivButton();
        Assert.assertEquals(calcPage.GetResultField(), "5.00 / 0.00 = Infinity", "Result should be Infinity");
    }

    //testing not integer numbers

    @Test(priority = 17)
    private void testAdditionTwoPositiveFractionalNumbers()
    {
        calcPage.SetFirstField("2.5");
        calcPage.SetSecondField("3.456");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "2.50 + 3.46 = 5.96", "Result should be 5.96");
    }
    @Test(priority = 18)
    private void testAdditionTwoNegativeFractionalNumbers()
    {
        calcPage.SetFirstField("-2.5");
        calcPage.SetSecondField("-3.456");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "-2.50 + -3.46 = -5.96", "Result should be -5.96");
    }

    @Test(priority = 19)
    private void testSubtractionTwoPositiveFractionalNumbers()
    {
        calcPage.SetFirstField("4.6");
        calcPage.SetSecondField("3.456");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "4.60 - 3.46 = 1.14", "Result should be 1.14");
    }
    @Test(priority = 20)
    private void testSubtractionTwoNegativeFractionalNumbers()
    {
        calcPage.SetFirstField("-4.6");
        calcPage.SetSecondField("-3.456");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "-4.60 - -3.46 = -1.14", "Result should be -1.14");
    }

    @Test(priority = 21)
    private void testMultiplyTwoPositiveFractionalNumbers()
    {
        calcPage.SetFirstField("4.6");
        calcPage.SetSecondField("3.456");
        calcPage.ClickMulButton();;

        Assert.assertEquals(calcPage.GetResultField(), "4.60 * 3.46 = 15.92", "Result should be 15.92");
    }
    @Test(priority = 22)
    private void testMultiplyTwoNegativeFractionalNumbers()
    {
        calcPage.SetFirstField("-4.6");
        calcPage.SetSecondField("-3.456");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "-4.60 * -3.46 = 15.92", "Result should be 15.92");
    }
    @Test(priority = 23)
    private void testMultiplyTwoDifferentFractionalNumbers()
    {
        calcPage.SetFirstField("-4.6");
        calcPage.SetSecondField("3.456");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "-4.60 * 3.46 = -15.92", "Result should be -15.92");
    }
    @Test(priority = 24)
    private void testDivTwoPositiveFractionalNumbers()
    {
        calcPage.SetFirstField("4.6");
        calcPage.SetSecondField("3.456");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "4.60 / 3.46 = 1.33", "Result should be 1.33");
    }
    @Test(priority = 25)
    private void testDivTwoNegativeFractionalNumbers()
    {
        calcPage.SetFirstField("-4.6");
        calcPage.SetSecondField("-3.456");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "-4.60 / -3.46 = 1.33", "Result should be 1.33");
    }
    @Test(priority = 26)
    private void testDivTwoDifferentFractionalNumbers()
    {
        calcPage.SetFirstField("4.6");
        calcPage.SetSecondField("-3.456");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "4.60 / -3.46 = -1.33", "Result should be -1.33");
    }

    @Test(priority = 27)
    private void testAdditionTwoBigNumbers() throws InterruptedException {
        calcPage.SetFirstField("10000000000000");
        calcPage.SetSecondField("5000000000000");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "10000000000.00 + 5000000000000.00 = 15000000000000.00", "Result should be 15000000000000");

    }
    @Test(priority = 28)
    private void testAdditionTwoNegativeBigNumbers()
    {
        calcPage.SetFirstField("-10000000000000");
        calcPage.SetSecondField("-5000000000000");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "-10000000000.00 + -5000000000000.00 = -15000000000000.00", "Result should be -15000000000000");

    }
    @Test(priority = 29)
    private void testSubtractionTwoBigNumbers() {
        calcPage.SetFirstField("10000000000000");
        calcPage.SetSecondField("5000000000000");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "10000000000.00 - 5000000000000.00 = 5000000000000.00", "Result should be 5000000000000");

    }
    @Test(priority = 30)
    private void testSubtractionTwoNegativeBigNumbers() {
        calcPage.SetFirstField("-10000000000000");
        calcPage.SetSecondField("-5000000000000");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "-10000000000.00 - -5000000000000.00 = -5000000000000.00", "Result should be -5000000000000");

    }
    @Test(priority = 31)
    private void testMultiplyTwoBigNumbers() {
        calcPage.SetFirstField("10000000000");
        calcPage.SetSecondField("5000");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "10000000000.00 * 5000.00 = 50000000000000.00", "Result should be 5000000000000");

    }
    @Test(priority = 32)
    private void testMultiplyTwoNegativeBigNumbers() {
        calcPage.SetFirstField("-10000000000");
        calcPage.SetSecondField("-5000");
        calcPage.ClickMulButton();

        Assert.assertEquals(calcPage.GetResultField(), "-10000000000.00 * -5000.00 = 50000000000000.00", "Result should be 5000000000000");

    }
    @Test(priority = 33)
    private void testDivTwoBigNumbers() throws InterruptedException {
        calcPage.SetFirstField("10000000000");
        calcPage.SetSecondField("5000");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "10000000000.00 / 5000.00 = 2000000.00", "Result should be 2000000");

    }
    @Test(priority = 34)
    private void testDivTwoNegativeBigNumbers() throws InterruptedException {
        calcPage.SetFirstField("-10000000000");
        calcPage.SetSecondField("-5000");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "-10000000000.00 / -5000.00 = 2000000.00", "Result should be 2000000");

    }

    @Test(priority = 35)
    private void testAdditionNumbersWithSpace() {
        calcPage.SetFirstField("5 5");
        calcPage.SetSecondField("2 2");
        calcPage.ClickAddButton();

        Assert.assertEquals(calcPage.GetResultField(), "Please, fill the input fields correctly");

    }
    @Test(priority = 36)
    private void testSubtractionNumbersWithSpace() {
        calcPage.SetFirstField("5 5");
        calcPage.SetSecondField("2 2");
        calcPage.ClickSubButton();

        Assert.assertEquals( calcPage.GetResultField(), "Please, fill the input fields correctly");

    }
    @Test(priority = 37)
    private void testMultiplyNotNumbersInFields()
    {
        calcPage.SetFirstField("aA");
        calcPage.SetSecondField("bB");
        calcPage.ClickSubButton();

        Assert.assertEquals(calcPage.GetResultField(), "Please, fill the input fields correctly");

    }
    @Test(priority = 38)
    private void testDivNotNumbersInFields()
    {
        calcPage.SetFirstField("2A");
        calcPage.SetSecondField("1B");
        calcPage.ClickDivButton();

        Assert.assertEquals(calcPage.GetResultField(), "Please, fill the input fields correctly");

    }



    @AfterMethod()
    private void resetting() throws InterruptedException
    {
        calcPage.ClickResetButton();
    }

    @AfterSuite()
    private void close() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
    }
}