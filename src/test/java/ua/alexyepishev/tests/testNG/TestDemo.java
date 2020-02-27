package ua.alexyepishev.tests.testNG;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@Slf4j
public class TestDemo extends BaseTest {
    @Test(priority = 2)
    void demoTest1() {
        log.info("");
        System.out.println("My testDemo1");
    }

    @Test(dataProvider = "invalidCredentials", testName = "Login with valid credentials", description = "My test description")
    void loginWithValidCredentials(String userName, int userID) {
        System.out.println("My testDemo2");
        System.out.println(userName + " " + userID);
    }

    @Test(dependsOnMethods = "loginWithValidCredentials")
    void userPageIsDisplayedWithMainElements() {
        System.out.println("My testDemo3");
    }

    @DataProvider
    Object[][] invalidCredentials() {
        //my logic
        return new Object[][] {
                {"Alex", 123},
                {"Olya", 321},
                {"Vasya", 521},
        };
    }


}
