package project.tests;

import org.junit.Test;
import project.pages.booking.BookingMainPage;
import project.pages.booking.BookingRegistrationPage;
import project.pages.mailru.MailruMainPage;
import project.steps.PreconditionSteps;
import project.utils.PasswordGenerator;

public class BookingRegistrationTest extends BaseTest {

    private MailruMainPage mailruMainPage = new MailruMainPage();
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage();

    @Test
    public void bookingRegistrationTest() {
        var disposableAddress = PreconditionSteps.createAndGetNewTrashMailAddress();
        bookingMainPage.openBookingMainPage();
        bookingMainPage.acceptCookies();
        bookingMainPage.clickRegisterButton();
        bookingRegistrationPage.enterEmailAddress(disposableAddress);
        bookingRegistrationPage.submitButton();
        bookingRegistrationPage.enterAndConfirmPassword(PasswordGenerator.generatePasswordForBooking());
        bookingRegistrationPage.submitButton();

//        bookingMainPage.closeWelcomeMessage();

        mailruMainPage.openMailruMainPage();
        mailruMainPage.clickLoginButton();
        mailruMainPage.loginWithDefaultCredentials();
    }
}

/*открыть трэшмейл
 * создать фейковую почту на тестовый имейл
 * прихранить имя фейк почты
 * открыть букинг
 * зарегистрироваться там
 * открыть тестовую почту
 * найти письмо от букинга
 * нажать подтверждение
 * перейти в настройки аккаунта
 * проверить что нет уведомления*/