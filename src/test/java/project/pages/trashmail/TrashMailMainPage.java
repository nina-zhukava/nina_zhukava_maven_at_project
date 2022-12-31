package project.pages.trashmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import project.objects.Credentials;

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
//        driver.findElement(By.xpath("//*[@id='fe-fwd-nb']/option["+ number +"]")).click();
        driver.findElement(By.xpath("//*[@id='fe-mob-fwd-nb']")).click();
        driver.findElement(By.xpath("//*[@id='fe-mob-fwd-nb']/option[2]")).click();
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
