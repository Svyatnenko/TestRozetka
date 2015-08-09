package pageobject.setup;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.SetupDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {

    WebDriver driver;

    @FindBy(xpath="html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")
    WebElement link;


    @FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/input")
    WebElement login;

    @FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/input")
    WebElement password;

    @FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[2]/div/span/button")
    WebElement submit;

    @FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/div[2]/h5")
    WebElement window;

    @FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")
    WebElement loginPopUp;

    public void open(){
        driver = SetupDriver.getDriver();
        driver.get("http://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void doSmth(String user, String passwordValue){

        link.click();
        login.clear();
        login.sendKeys(user);
        password.clear();
        password.sendKeys(passwordValue);
        submit.click();


}

    public WebElement getLoginPopUp() {
        return loginPopUp;
    }

//@org.junit.Test
//public void testRozetkaChrome() throws Exception {
//        driver.get(baseUrl);
//        for (int second = 0;; second++) {
//        if (second >= 60) fail("timeout");
//        try { if ("войдите в личный кабинет".equals(driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")).getText())) break; } catch (Exception e) {}
//        Thread.sleep(1000);
//        }

//        for (int second = 0;; second++) {
//        if (second >= 60) fail("timeout");
//        try { if ("¬веден неверный пароль!".equals(driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/div[2]/h5")).getText())) break; } catch (Exception e) {}
//        Thread.sleep(1000);
//        }
//
//        assertEquals("¬веден неверный пароль!", driver.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/div[2]/h5")).getText());
        }