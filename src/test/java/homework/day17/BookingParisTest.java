package homework.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class BookingParisTest extends BaseTest{

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("d MMMM yyyy");

    @Test
    public void bookingParisTest() {
        driver.get("http://booking.com");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        WebElement where = driver.findElement(By.xpath("//*[@aria-label='Type your destination' or @placeholder='Where are you going?']"));
        where.click();
        where.sendKeys("Paris");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results' or @aria-label='List of suggested destinations' or @role='listbox']/li[1]")).click();

        LocalDate date = LocalDate.now().plusDays(3);
        String startDateXPath = "//span[@aria-label='" + date.format(FORMAT) + "']";
        String endDateXPath = "//span[@aria-label='" + date.plusDays(10).format(FORMAT) + "']";
        driver.findElement(By.xpath(startDateXPath)).click();
        driver.findElement(By.xpath(endDateXPath)).click();
        WebElement peopleAndRoomQuantity = driver.findElement(By.xpath("//form[@method='GET']//div[3]//button[@type='button' or  @role='button']"));
        if (peopleAndRoomQuantity.isDisplayed()) {
            peopleAndRoomQuantity.click();
        } else {
            driver.findElement(By.xpath("//*[@data-visible='accommodation,flights']"));
        }

        driver.findElement(By.xpath("//*[@data-testid='occupancy-popup']//div[1]//div[1]//button[@type='button'][2]")).click();//span +button
        driver.findElement(By.xpath("//*[@data-testid='occupancy-popup']//div[1]//div[1]//button[@type='button'][2]")).click();

        driver.findElement(By.xpath("//*[@data-testid='occupancy-popup']//div[3]//button[@type='button'][2]")).click();

        driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Search')]")).click();
        driver.findElement(By.xpath("//*[@id='searchresultsTmpl']//*[@data-testid='filters-sidebar']//*[@data-filters-item='pri:pri=5']")).click();

        int minPrice = Integer.parseInt(Arrays.stream(driver.findElement(By.xpath("//*[@id='left']//*[@data-testid='filters-sidebar" +
                "']//*[@data-filters-item='pri:pri=5']")).getText().split(" ")).findFirst().get().replace(",",""));

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.findElement(By.xpath("//*[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//*[@data-testid='sorters-dropdown']//ul/li[3]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Price (lowest first)')]")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement result = driver.findElement(By.xpath("//*[@data-testid='property-card'][1]//span[@data-testid='price-and-discounted-price']"));
        int price = Integer.parseInt(Arrays.stream(result.getText().split(" ")).findFirst().get().replace(",","")) / 7;
        assertTrue("Price is less than minimal", price >= minPrice);
    }
}
