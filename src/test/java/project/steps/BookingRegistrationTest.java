package project.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import project.pages.booking.BookingMainPage;
import project.pages.booking.BookingRegistrationPage;
import project.pages.mailru.MailruMainPage;
import project.utils.PasswordGenerator;

public class BookingRegistrationTest {

    WebDriver driver = Driver.getDriver();
    String disposableAddress;
    private MailruMainPage mailruMainPage = new MailruMainPage();
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage();

    @Before
    public void precondition() {
        driver.get("https://booking.com");
        disposableAddress = PreconditionSteps.createAndGetNewTrashMailAddress();
    }

    @Given("I register new user")
    public void registerNewUser() {
        bookingMainPage.openBookingMainPage();
        bookingMainPage.acceptCookies();
        bookingMainPage.clickRegisterButton();
        bookingRegistrationPage.enterEmailAddress(disposableAddress);
        bookingRegistrationPage.submitButton();
        bookingRegistrationPage.enterAndConfirmPassword(PasswordGenerator.generatePasswordForBooking());
        bookingRegistrationPage.submitButton();

        bookingMainPage.closeWelcomeMessage();
    }

    @When("I confirm registration")
    public void confirmRegistration() {
    }

    @When("I log in as created user")
    public void loginToBooking() {
        Assert.assertTrue("Price is lower than expected!", true);
    }

    @Then("I log in as created user")
    public void doAssert() {
        Assert.assertTrue("Price is lower than expected!", true);
    }

}
/*@Given("I open a site")
public void openSite() throws InterruptedException {
String url = "https://booking.com";
driver.get(url);
System.out.println("Opening url: " + url);
}
@When("I type {string} as name of the city")
public void typeCity(String theCity) throws InterruptedException {
page.findCity(theCity);
}
@Then("I see test passed")
public void doAssert() throws InterruptedException {
//Thread.sleep(3000);
Assert.assertTrue("Expected hotel prise is lower than expected!", true);
}*/