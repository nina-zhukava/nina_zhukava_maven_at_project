package project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
