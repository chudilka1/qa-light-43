package ua.alexyepishev.tests.api.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.alexyepishev.tests.seleniumTests.TestService;

@UtilityClass
public class CustomSeleniumActions {
    private WebDriver driver = TestService.getDriver();

    public static WebElement doFind(By selector) {
        return driver.findElement(selector);
    }

    public static void doSendKeys(By selector, String text) {
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(text);
    }
}
