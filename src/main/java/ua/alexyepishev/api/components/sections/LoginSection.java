package ua.alexyepishev.api.components.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.alexyepishev.api.components.buttons.Button;
import ua.alexyepishev.api.components.buttons.SubmitButton;

public class LoginSection {
    private final By rootSelector = By.className("login-box-body");
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
        return new Button(this.driver, this.rootSelector);
    }

    /*public Button getCancelButton() {
        return new Button(this.driver, this.rootSelector);
    }*/


    public LoginSection typeUsername(String username) {
        sendKeys(username, USERNAME_INPUT_SELECTOR);
        return this;
    }

    public LoginSection typePassword(String password) {
        sendKeys(password, PASSWORD_INPUT_SELECTOR);
        return this;
    }

    private void sendKeys(String value, By selector) {
        this.driver.findElement(selector).clear();
        this.driver.findElement(selector).sendKeys(value);
    }
}
