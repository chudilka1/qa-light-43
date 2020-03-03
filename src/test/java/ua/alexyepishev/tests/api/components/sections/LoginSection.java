package ua.alexyepishev.tests.api.components.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import ua.alexyepishev.tests.api.components.buttons.Button;

import static ua.alexyepishev.tests.api.utils.CustomSeleniumActions.doSendKeys;

public class LoginSection {
    private final By rootSelector = By.className("login-box-");
    private static final By USERNAME_INPUT_SELECTOR = By.name("_username");
    private static final By PASSWORD_INPUT_SELECTOR = By.id("password");

    private WebDriver driver;

    public LoginSection(WebDriver driver) {
        this.driver = driver;
    }

    /*public SubmitButton getSubmitButton() {
        return new SubmitButton(this.driver);
    }*/
    public Button getSubmitButton() {
        return new Button(this.rootSelector);
    }

    public Button getCancelButton() {
        By cancelButtonSelector = new ByChained(this.rootSelector, By.cssSelector("button[class*=\"cancel\"]"));
        WebElement cancelButtonElement = this.driver.findElement(cancelButtonSelector);
        return new Button(cancelButtonElement);
    }

    public LoginSection typeUsername(String username) {
        doSendKeys(USERNAME_INPUT_SELECTOR, username);
        return this;
    }

    public LoginSection typePassword(String password) {
        doSendKeys(PASSWORD_INPUT_SELECTOR, password);
        return this;
    }
}
