package ua.alexyepishev.tests.seleniumTests.suites.steps;

import io.qameta.allure.Step;
import ua.alexyepishev.tests.api.components.pages.LoginPage;
import ua.alexyepishev.tests.api.components.sections.LoginSection;
import ua.alexyepishev.tests.seleniumTests.TestProperties;
import ua.alexyepishev.tests.seleniumTests.TestService;

public class LoginPageSteps {
    LoginPage loginPage;

    public LoginPageSteps() {
        TestProperties properties = TestProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHost();
        this.loginPage = new LoginPage(TestService.getDriver(), baseUrl);
    }

    @Step("Open Login Page")
    public LoginPageSteps openLoginPage() {
        this.loginPage.open();
        return this;
    }

    @Step("Verify Login Page title is '{0}'")
    public LoginPageSteps verifyTitleIs(String title) {
        this.loginPage.verifyTitleIs(title);
        return this;
    }

    @Step("Log in with username '{0}' and password {1}")
    public LoginPageSteps signIn(String username, String password) {
        LoginSection loginSection = this.loginPage.getLoginSection();
        loginSection
                .typeUsername(username)
                .typePassword(password)
                .getSubmitButton()
                .click();
        return this;
    }
}
