package homework.day17;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookingScriptTest {
    private static WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

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

    @After
    public void postCondition() {
        driver.close();
        driver.quit();
    }
}