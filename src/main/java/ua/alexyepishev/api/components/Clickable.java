package ua.alexyepishev.api.components;

import org.openqa.selenium.WebElement;

public interface Clickable {
    default boolean verifyEnabled() {
        //my logic
        System.out.println("I AM ENABLED");
        return true;
    }

    default WebElement click() {
        return null;
    }
}
