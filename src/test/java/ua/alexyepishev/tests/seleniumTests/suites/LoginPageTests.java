package ua.alexyepishev.tests.seleniumTests.suites;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.alexyepishev.tests.api.components.buttons.Button;
import ua.alexyepishev.tests.api.components.pages.LoginPage;
import ua.alexyepishev.tests.api.components.sections.LoginSection;
import ua.alexyepishev.tests.seleniumTests.TestProperties;
import ua.alexyepishev.tests.seleniumTests.TestService;
import ua.alexyepishev.tests.seleniumTests.suites.steps.LoginPageSteps;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Login")
@Issue("MRPT-1234")
public class LoginPageTests extends TestService {
    private static final String PASSWORD = "909090";
    private static final String USERNAME = "Student";

    private WebDriver driver;
    private LoginPageSteps loginPage;

    @Override
    @BeforeClass
    public void setUp() {
        System.out.println("In Before class");
        this.driver = getDriver();
        this.loginPage = new LoginPageSteps();
    }

    @Test(description = "Successfully login with valid user credentials")
    @Description("I usually describe test scenario")
    @Severity(BLOCKER)
    @Issue("MTRRJ-1235")
    void successfullyLoginWithValidUserCredentials() {
        loginPage.openLoginPage()
                .verifyTitleIs("Учет запчастей")
                .signIn(USERNAME, PASSWORD);

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
        submitButton.click();
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
