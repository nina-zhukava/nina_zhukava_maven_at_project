package homework.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BookingDatesTest extends BaseTest {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("d MMMM yyyy");

    @Test
    public void bookingDatesTest() {
        driver.get("http://booking.com");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        WebElement where = driver.findElement(By.xpath("//*[@aria-label='Type your destination' or @placeholder='Where are you going?']"));
        where.click();
        where.sendKeys("Paris");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results' or @aria-label='List of suggested destinations' or @role='listbox']/li[1]")).click();

        LocalDate date = LocalDate.now().plusDays(1);
        String startDateXPath = "//span[@aria-label='" + date.format(FORMAT) + "']";
        String endDateXPath = "//span[@aria-label='" + date.plusDays(2).format(FORMAT) + "']";
        driver.findElement(By.xpath(startDateXPath)).click();
        driver.findElement(By.xpath(endDateXPath)).click();
        driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Search')]")).click();

        List<WebElement> result = driver.findElements(By.xpath("//*[@data-block-id='hotel_list']//div[@data-testid='property-card']"));
        assertTrue(result.size() > 0);
    }
}
