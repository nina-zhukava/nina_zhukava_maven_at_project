package project.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;

public class BaseTest {

    WebDriver driver = Driver.getDriver();

    @Before
    public void setUp() {
    }

    @After
    public void postCondition() {
        driver.close();
        driver.quit();
    }
}
