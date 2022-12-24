package project.pages.booking;

import project.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingMainPage {

    WebDriver driver = Driver.getDriver();

    public void openBookingMainPage () {
        driver.get("http://booking.com");
    }

    public void acceptCookies () {
        driver.findElement(By.xpath("//*[@id='onetrust-banner-sdk']//*[@id='onetrust-accept-btn-handler']")).click();
    }

    public void clickRegisterButton () {
        driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();
    }

    public void closeWelcomeMessage() {
        driver.findElement(By.xpath("//*[@role='dialog']/button"));
    }
}
