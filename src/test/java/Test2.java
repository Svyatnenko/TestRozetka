
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Test.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test2 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\Progs\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://luciana.integro.kiev.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void testTest2() throws Exception {

        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("fdggh@ff.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("gfsdhgfh");
        driver.findElement(By.id("reg_email")).clear();
        driver.findElement(By.id("reg_email")).sendKeys("fdggh@ff.com");
        driver.findElement(By.id("reg_password")).clear();
        driver.findElement(By.id("reg_password")).sendKeys("gfsdhgfh");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector(".welcome_username"));
        assertEquals("ƒŒ¡–Œ œŒ∆¿ÀŒ¬¿“‹, FDGGH", driver.findElement(By.cssSelector("span.welcome_username")).getText());

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
