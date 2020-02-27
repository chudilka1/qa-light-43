package ua.alexyepishev.tests.seleniumTests.suites.user_profile;

import org.testng.annotations.Test;
import ua.alexyepishev.tests.seleniumTests.TestService;

public class MyTestSuite2 extends TestService {
    @Test
    void myTest() {
        System.out.println("I AM IN SUITE 2");
    }
}
