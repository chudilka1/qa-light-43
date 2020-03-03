package ua.alexyepishev.tests.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SubmitButton {
    private static final By SUBMIT_BUTTON_SELECTOR = By.cssSelector("button[type=\"submit\"]");

    private WebDriver driver;

    public SubmitButton(WebDriver driver) {
        this.driver = driver;
    }

    public SubmitButton clickSubmitButton() {
        this.driver.findElement(SUBMIT_BUTTON_SELECTOR).click();
        return this;
    }

    public SubmitButton verifySubmitButtonIsVisible() {
        this.driver.findElement(SUBMIT_BUTTON_SELECTOR).isDisplayed();
        return this;
    }

    public SubmitButton verifyNumberOfSubmitButtonsIs(int expectedResult) {
        int actualResult = this.driver.findElements(SUBMIT_BUTTON_SELECTOR).size();
        assertThat(actualResult)
                .withFailMessage("Number of '%s' is not '%d'", "Submit buttons", expectedResult)
                .isEqualTo(expectedResult);
        return this;
    }
}