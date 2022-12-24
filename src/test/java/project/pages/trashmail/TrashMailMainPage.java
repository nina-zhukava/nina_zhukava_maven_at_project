package project.pages.trashmail;

import project.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.objects.Credentials;

public class TrashMailMainPage {

    WebDriver driver = Driver.getDriver();

    public void openTrashMailMainPage() {
        driver.get("https://trashmail.com/");
    }

    public void enterRealAddress() {
        driver.findElement(By.xpath("//*[@id='fe-mob-forward']")).sendKeys(Credentials.MAILRU.getAddress());
    }

    public void chooseNumberOfForwards(int number) {
        driver.findElement(By.xpath("//*[@id='fe-mob-fwd-nb']/option["+ number +"]")).click();
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
