package ua.alexyepishev.tests.testNG;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    void setUp() {
        System.out.println("I am in before suite");
    }

    @BeforeClass
    void setUp2() {
        System.out.println("I am in before class");
    }

    @BeforeMethod
    void setUp3() {
        System.out.println("I am in before method");
    }

    @AfterMethod
    void tearDown() {
        System.out.println("I am in after method");
    }

    private void sum() {}

    @AfterClass
    void tearDown2() {
        System.out.println("I am in after class");
    }

    @AfterSuite
    void tearDown3() {
        System.out.println("I am in after suite");
    }
}
