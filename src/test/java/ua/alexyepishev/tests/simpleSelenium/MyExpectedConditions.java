package ua.alexyepishev.tests.simpleSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyExpectedConditions {
    public static ExpectedCondition myElementDisplayed(By usernameSelector) {
        return (ExpectedCondition<Boolean>) webDriver -> {
            try {
                WebElement webElement = webDriver.findElement(usernameSelector);
                return webElement.isDisplayed();
            } catch (final StaleElementReferenceException e) {
                return false;
            }
        };
    }
}
