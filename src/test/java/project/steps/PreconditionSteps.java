package project.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;
import project.pages.trashmail.TrashMailMainPage;

import java.util.Arrays;

public class PreconditionSteps {

    private static WebDriver driver = Driver.getDriver();
    private static TrashMailMainPage trashMail = new TrashMailMainPage();

    public static String createAndGetNewTrashMailAddress() {
        trashMail.openTrashMailMainPage();
        trashMail.enterRealAddress();
        trashMail.chooseNumberOfForwards(2);
        trashMail.chooseOneDayLifeSpan();
        trashMail.clickCreateAddressButton();
        WebElement element = driver.findElement(By.xpath("//h4"));
        return Arrays.stream(element.getText().split("\n")).findFirst().get();
    }
}
