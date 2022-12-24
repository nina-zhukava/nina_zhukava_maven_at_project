package project.pages.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import project.objects.Credentials;

public class MailruMainPage {

    WebDriver driver = Driver.getDriver();

    public void openMailruMainPage () {
        driver.get("https://mail.ru/");
    }

    public void clickLoginButton () {
        driver.findElement(By.cssSelector("[data-testid='enter-mail-primary']")).click();
    }

    public void loginWithDefaultCredentials () {
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(Credentials.MAILRU.getAddress());
        driver.findElement(By.cssSelector("[data-test-id='next-button']")).click();
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(Credentials.MAILRU.getAddress());
        driver.findElement(By.cssSelector("[data-test-id='submit-button']")).click();
    }
}
