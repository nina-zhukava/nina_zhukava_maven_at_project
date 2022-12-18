package homework.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BookingScriptTest extends BaseTest {

    @Test
    public void bookingScriptTest() {
        driver.get("http://booking.com");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        WebElement where = driver.findElement(By.xpath("//*[@aria-label='Type your destination' or @placeholder='Where are you going?']"));
        where.click();
        where.sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results' or @aria-label='List of suggested destinations' or @role='listbox']/li[1]")).click();
        driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Search')]")).click();

        WebElement element = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", element);

        WebElement title = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]//*[@data-testid='title']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", title);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        assertEquals("color: red;", title.getAttribute("style"));
    }
}