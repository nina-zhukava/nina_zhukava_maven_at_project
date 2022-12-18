package homework.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ActionsTest extends BaseTest {

    @Test
    public void actionsTest() {
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.id("accept-choices")).click();
        Actions action = new Actions(driver);
        WebElement tutor = driver.findElement(By.xpath("//span[contains(text(),'Tutorial')]"));
        action.doubleClick(tutor)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//div[text()='Acceptă tot']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).click();
        action.keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
        action.sendKeys(Keys.ENTER)
                .build()
                .perform();

        List<WebElement> elementList = driver.findElements(By.xpath("//div[@data-header-feature='0']//h3"));

        List<String> titles = elementList.stream()
                .map(webElement -> webElement.getText().toLowerCase())
                .filter(element -> element.contains("tutorial"))
                .collect(Collectors.toList());
        assertEquals("Not every text search result contains 'tutorial'", elementList.size(), titles.size());
    }
}
