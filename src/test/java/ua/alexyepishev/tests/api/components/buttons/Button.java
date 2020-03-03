package ua.alexyepishev.tests.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import ua.alexyepishev.tests.api.components.Clickable;
import ua.alexyepishev.tests.api.components.Visible;

import static ua.alexyepishev.tests.api.utils.CustomSeleniumActions.doFind;

public class Button implements Visible, Clickable {
    private By rootSelector;
    private WebElement element;

    public Button(By parentSelector) {
        this.rootSelector = new ByChained(parentSelector, By.tagName("button"));
    }

    public Button(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getRootElement() {
        return this.rootSelector != null
                ? doFind(this.rootSelector)
                : this.element;
    }

    public boolean elementIsVisible() {
        /*if(this.rootSelector != null) return this.driver.findElement(rootSelector).isDisplayed();
        else return this.element.isDisplayed();*/
        return this.rootSelector != null
                ? doFind(rootSelector).isDisplayed()
                : this.element.isDisplayed();
    }

    public boolean elementIsNotVisible() {
        return false;
    }
}
