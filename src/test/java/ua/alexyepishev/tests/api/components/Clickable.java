package ua.alexyepishev.tests.api.components;

public interface Clickable extends RootElement {
    default boolean verifyEnabled() {
        getRootElement().isEnabled();
        return true;
    }

    default void click() {
        getRootElement().click();
        System.out.println("I WAS CLICKED");
    }
}
