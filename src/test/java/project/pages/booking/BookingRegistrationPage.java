package project.pages.booking;

import project.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingRegistrationPage {

    WebDriver driver = Driver.getDriver();

    public void enterEmailAddress (String email) {
        driver.findElement(By.xpath("//input[@type='email']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
    }
    public void submitButton () {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void enterAndConfirmPassword (String password) {
        driver.findElement(By.xpath("//input[@name='new_password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys(password);
    }
}