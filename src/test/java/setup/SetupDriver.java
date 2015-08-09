package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SetupDriver {
    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver","D:\\Progs\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}