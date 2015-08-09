
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SovaRun {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\Progs\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://127.0.0.1/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void testSovaRun() throws Exception {
        driver.get(baseUrl);

      }}