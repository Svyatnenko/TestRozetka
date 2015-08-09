
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rozetka {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void testRozetka() throws Exception {
        driver.get(baseUrl);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("войдите в личный кабинет".equals(driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")).click();
        driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/input")).clear();
        driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/input")).sendKeys("paha_sv@ukr.net");
        driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/input")).sendKeys("qwert123");
        driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[2]/div/span/button")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("¬веден неверный пароль!".equals(driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/div[2]/h5")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

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

