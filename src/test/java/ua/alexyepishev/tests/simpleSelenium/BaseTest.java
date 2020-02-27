package ua.alexyepishev.tests.simpleSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static Logger LOG = LoggerFactory.getLogger(SeleniumDemoTest.class);
    protected WebDriver driver;

    @BeforeSuite
    void setUp() {
        initDriver();
        configureDriver();
    }

    private void configureDriver() {
        LOG.info("Configuring driver");
        long timeout = 15L;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        LOG.info("Driver was configured with implicit timeout {} seconds", timeout);
    }

    private void initDriver() {
        LOG.info("Driver initialization");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\QaLight\\Desktop\\alex-yepishev-selenium-practice\\src\\test\\resources\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        LOG.info("Driver was initialized");
    }

    @AfterClass
    private void tearDown() {
        if (this.driver != null) {
            LOG.info("Quiting driver");
            this.driver.close();
            this.driver.quit();
            LOG.info("Driver was quit");
        }
    }

    void openIndexPage() {
        driver.get("http://v3.test.itpmgroup.com");
    }
}
