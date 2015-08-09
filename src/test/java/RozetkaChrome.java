
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static setup.SetupDriver.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.setup.MainPage;
import setup.SetupDriver;

public class RozetkaChrome {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
    }

    @org.junit.Test
    public void testRozetkaChrome() throws Exception {
        MainPage page = PageFactory.initElements(driver, MainPage.class);
        page.open();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("войдите в личный кабинет".equals(page.getLoginPopUp().getText()))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        page.doSmth("paha_sv@ukr.net", "qwert123");

        assertEquals("¬веден неверный пароль!", driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/div[2]/h5")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

