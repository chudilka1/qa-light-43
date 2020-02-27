package ua.alexyepishev.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import ua.alexyepishev.api.components.Clickable;
import ua.alexyepishev.api.components.Visible;

public class Button implements Visible, Clickable {
    private WebDriver driver;
    private final By rootSelector;

    public Button(WebDriver driver, By parentSelector) {
        this.driver = driver;
        this.rootSelector = new ByChained(parentSelector, By.tagName("button"));
    }

    public boolean elementIsVisible() {
        return this.driver.findElement(rootSelector).isDisplayed();
    }

    public boolean elementIsNotVisible() {
        return false;
    }
}
