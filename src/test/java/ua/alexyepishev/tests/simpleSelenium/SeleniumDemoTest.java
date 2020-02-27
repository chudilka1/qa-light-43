package ua.alexyepishev.tests.simpleSelenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumDemoTest extends BaseTest {
    @Test
    void test1() {
        driver.get("https://mvnrepository.com/");
        driver.findElement(By.cssSelector("p[class=\"im-subtitle\"]>a")).click();
    }

    @Test
    void test2() {
        driver.get("https://mvnrepository.com/");
        driver.findElement(By.cssSelector("p[class=\"im-subtitle\"]>a")).click();
    }
}
