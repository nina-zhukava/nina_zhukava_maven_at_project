package homework.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class HoverTest extends BaseTest {

    @Test
    public void currencyTooltipTest() {
        driver.get("https://booking.com");
        WebElement element = driver.findElement(By.xpath("//*[@data-modal-aria-label='Select your currency']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        WebElement tooltip = driver.findElement(By.xpath("//div[@role='tooltip']/*[@class='bui-tooltip__content']"));
        assertEquals(tooltip.getText(), "Choose your currency");
    }

    @Test
    public void languageTooltipTest() {
        driver.get("https://booking.com");
        WebElement element = driver.findElement(By.xpath("//*[@data-modal-aria-label='Select your currency']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        WebElement tooltip = driver.findElement(By.xpath("//div[@role='tooltip']/*[@class='bui-tooltip__content']"));
        assertEquals(tooltip.getText(), "Choose your language");
    }
}