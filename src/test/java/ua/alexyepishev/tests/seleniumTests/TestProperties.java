package ua.alexyepishev.tests.seleniumTests;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

@Slf4j
public class TestProperties {
    private static final String CONFIG_FILE = "tests.properties";

    public static final String BROWSER = Optional.ofNullable(System.getProperty("browser")).orElse("FIREFOX");

    @Getter
    private static final TestProperties instance = new TestProperties();
    private final Properties properties;

    private TestProperties() {
        properties = new Properties();

        this.setDefaultProperties();

        this.getPropertiesFromConfigFile();

        properties.putAll(System.getProperties());
    }

    /**
     * Gets properties from domain.properties file
     */
    private void getPropertiesFromConfigFile() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE);

        if (inputStream != null)
            try {
                properties.load(inputStream);
                log.info("Properties from " + CONFIG_FILE + " are obtained");
            } catch (IOException | IllegalArgumentException e) {
                String errorMessage = "Can't get properties from " + CONFIG_FILE;
                log.error(errorMessage, e);
                throw new IllegalStateException(errorMessage, e);
            }
        else {
            log.warn("No " + CONFIG_FILE + " file found! Default properties are used");
        }
    }

    /**
     * Sets default properties to be used in framework
     * (if the .properties file is not accessible
     * or necessary parameters are not passed)
     */
    private void setDefaultProperties() {
        properties.setProperty("test.scheme", "http://");
        properties.setProperty("test.baseUrl", "v3.test.itpmgroup.com");
    }

    /**
     * Getters for properties
     */
    public String getScheme() {
        return properties.getProperty("test.scheme");
    }

    public String getHost() {
        return properties.getProperty("test.baseUrl");
    }
}
