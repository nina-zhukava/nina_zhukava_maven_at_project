package project.pages.trashmail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import project.driver.Driver;
import project.objects.Credentials;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TrashMailMainPage {

    WebDriver driver = Driver.getDriver();

    public void openTrashMailMainPage() {
        driver.get("https://trashmail.com/");
    }

    public void enterRealAddress() {
//        driver.findElement(By.xpath("//*[@id='fe-mob-forward' or @id='fe-forward']")).click();
        driver.findElement(By.xpath("//*[@id='fe-forward']")).click();
//        driver.findElement(By.xpath("//*[@id='fe-mob-forward']")).sendKeys(Credentials.MAILRU.getAddress());
        driver.findElement(By.xpath("//*[@id='fe-forward']")).sendKeys(Credentials.MAILRU.getAddress());
    }

    public void chooseNumberOfForwards(int number) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fe-fwd-nb']")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='fe-fwd-nb']")).click();
        driver.findElement(By.xpath("//*[@id='fe-fwd-nb']/option[" + number + "]")).click();
    }

    public void chooseOneDayLifeSpan() {
        driver.findElement(By.xpath("//*[@id='fe-mob-life-span']/option[1]")).click();
    }

    public void clickCreateAddressButton() {
        driver.findElement(By.xpath("//*[@id='fe-mob-submit']")).click();
    }

    public void getCreatedAddress() {
        driver.findElement(By.xpath("//*[@id='fe-mob-life-span']/option[1]")).click();
    }
}
