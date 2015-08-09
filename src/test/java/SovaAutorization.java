import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SovaAutorization {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\Progs\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://127.0.1.1/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @org.junit.Test
    public void testSovaAutorization() throws Exception {
        driver.get(baseUrl);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Логин \n Пароль".equals(driver.findElement(By.cssSelector("div.login-form")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        assertEquals("", driver.findElement(By.cssSelector("img..firepath-matching-node")).getText());
        assertEquals("Логин", driver.findElement(By.cssSelector("label")).getText());
        assertEquals("Пароль", driver.findElement(By.xpath("//div[2]/label")).getText());
        assertEquals("", driver.findElement(By.cssSelector("input.btn.btn-dark-gray")).getText());
        driver.findElement(By.id("InputLogin")).clear();
        driver.findElement(By.id("InputLogin")).sendKeys("lms");
        driver.findElement(By.id("InputPassword")).clear();
        driver.findElement(By.id("InputPassword")).sendKeys("lms");
        driver.findElement(By.cssSelector("input.btn.btn-dark-gray")).click();
        assertEquals(">Объект Поиск Графики Отчеты \n \n lms", driver.findElement(By.id("header")).getText());
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
