import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SovaObject {
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
    }

    @org.junit.Test
    public void testSovaObject() throws Exception {
        driver.get(baseUrl);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("SOVA".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("", driver.findElement(By.cssSelector("a.logo")).getText());
        assertEquals("Объект", driver.findElement(By.cssSelector("h1.title")).getText());
        assertEquals("Название объекта:", driver.findElement(By.cssSelector("p.obj-ttl")).getText());
        assertEquals("SOVA", driver.findElement(By.xpath("//p[2]")).getText());
        assertEquals("", driver.findElement(By.cssSelector("div.inf-row > img")).getText());
        assertEquals("Адрес:", driver.findElement(By.xpath("//div[3]/p")).getText());
        assertEquals("Address", driver.findElement(By.xpath("//div[3]/p[2]")).getText());
        assertEquals("Контактные данные объекта:", driver.findElement(By.xpath("//div[3]/div/div/div/p")).getText());
        assertEquals("Position", driver.findElement(By.cssSelector("div.object-crew > p")).getText());
        assertEquals("Name", driver.findElement(By.xpath("//div[4]/p[2]")).getText());
        assertEquals("Tel number", driver.findElement(By.xpath("//p[3]")).getText());
        assertEquals("Email", driver.findElement(By.linkText("Email")).getText());
        assertEquals("", driver.findElement(By.cssSelector("img.img-responsive")).getText());
        assertEquals("Floor name", driver.findElement(By.linkText("Floor name")).getText());
        assertEquals("Объект", driver.findElement(By.linkText("Объект")).getText());
        assertEquals("Поиск", driver.findElement(By.linkText("Поиск")).getText());
        assertEquals("Графики", driver.findElement(By.linkText("Графики")).getText());
        assertEquals("Отчеты", driver.findElement(By.linkText("Отчеты")).getText());
        assertEquals("lms", driver.findElement(By.linkText("lms")).getText());
        assertEquals("", driver.findElement(By.cssSelector("span.glyphicon.glyphicon-cog")).getText());
        assertEquals("©2015 — «SOVA» All rights reserved", driver.findElement(By.cssSelector("div.col-md-12.col-sm-12 > p")).getText());
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
