package classwork.day22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("appium:deviceName", "Pixel4");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.android.chrome)");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main)");
        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:autoAcceptAlerts", true);

        WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        driver.get("https://www.ikea.com/");

        Thread.sleep(5000);
        driver.quit();
    }
}
