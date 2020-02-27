package ua.alexyepishev.tests.seleniumTests.suites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.alexyepishev.api.components.buttons.Button;
import ua.alexyepishev.api.components.pages.LoginPage;
import ua.alexyepishev.api.components.sections.LoginSection;
import ua.alexyepishev.tests.seleniumTests.TestProperties;
import ua.alexyepishev.tests.seleniumTests.TestService;

public class LoginPageTests extends TestService {
    private static final String PASSWORD = "909090";
    private static final String USERNAME = "Student";

    private WebDriver driver;

    @Override
    @BeforeClass
    public void setUp() {
        System.out.println("In Before class");
        this.driver = getDriver();
    }

    @Test
    void successfullyLoginWithValidUserCredentials() {
        LoginPage loginPage = new LoginPage(driver, "http://v3.test.itpmgroup.com");
        loginPage.open()
                .verifyTitleIs("Учет запчастей");
        LoginSection loginSection = loginPage.getLoginSection();
        loginSection
                .typeUsername(USERNAME)
                .typeUsername(USERNAME)
                .typePassword(PASSWORD)
                .getSubmitButton();
                //.clickSubmitButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "invalidUserCredentials")
    void failWhenLoginWithInvalidUserCredentials(String username, String userpassword) {
        TestProperties properties = TestProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHost();
        LoginPage loginPage = new LoginPage(driver, baseUrl);
        loginPage.open()
                .verifyTitleIs("Учет запчастей");
        LoginSection loginSection = loginPage.getLoginSection();
        loginSection
                .typeUsername(username)
                .typePassword(userpassword);
        Button submitButton = loginSection.getSubmitButton();
        submitButton.elementIsVisible();
        submitButton.verifyEnabled();
                //submitButton.elementIsVisible();
                /*.clickSubmitButton()
                .verifySubmitButtonIsVisible()
                .verifyNumberOfSubmitButtonsIs(2);*/
    }

    @DataProvider
    private Object[][] invalidUserCredentials() {
        return new Object[][]{
                {"asdf", PASSWORD},
                {"", PASSWORD},
                {"as", PASSWORD},
                {USERNAME, ""},
                {USERNAME, "a"},
                {USERNAME, "123kh^&*"}

        };
    }
}
