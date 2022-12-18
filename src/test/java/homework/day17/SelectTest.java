package homework.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectTest extends BaseTest {

    @Test
    public void selectTest() {
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.id("withOptGroup")).click();
        driver.findElement(By.id("react-select-2-option-2")).click();

        driver.findElement(By.id("selectOne")).click();
        driver.findElement(By.id("react-select-3-option-0-3")).click();

        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
        select.getOptions();
        select.getFirstSelectedOption();

        driver.findElement(By.xpath("//b[contains(text(),'Multiselect drop down')]//parent::node()//parent::node()/div")).click();
        driver.findElement(By.id("react-select-4-option-3")).click();

        element = driver.findElement(By.id("cars"));
        select = new Select(element);
        select.selectByVisibleText("Opel");
    }
}