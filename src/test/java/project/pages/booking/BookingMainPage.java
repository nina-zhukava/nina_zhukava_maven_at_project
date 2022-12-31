package project.pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import project.driver.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BookingMainPage {

    WebDriver driver = Driver.getDriver();

    public void openBookingMainPage () {
        driver.get("http://booking.com");
    }

    public void acceptCookies () {
        driver.findElement(By.xpath("//*[@id='onetrust-banner-sdk']//*[@id='onetrust-accept-btn-handler']")).click();
    }

    public void clickRegisterButton() {
        driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();
    }

    public void closeWelcomeMessage() {
        driver.findElement(By.xpath("//*[@role='dialog']/button"));
    }

    public void passHumanVerification() {
        Actions actions = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Human verification challenge']")));
        WebElement element = driver.findElement(By.xpath("//*[@aria-label='Press and hold']"));
        actions.clickAndHold(element).build().perform();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.attributeContains(By.xpath("//*[@aria-label='Press and hold']/div[1]"
                ), "style", "width: 360px;"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
