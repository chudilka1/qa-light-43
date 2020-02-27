package ua.alexyepishev.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

public class MyUniqueButton extends Button {
    private WebDriver driver;
    private final By rootSelector;

    public MyUniqueButton (WebDriver driver, By parentSelector) {
        super(driver, parentSelector);
        this.driver = driver;
        this.rootSelector = new ByChained(parentSelector, By.tagName("button[class=\"cancel\"]"));
    }

    //my unique cancel button logic/methods
}
