package ua.alexyepishev.tests.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingNoLombok {
    private static Logger log = LoggerFactory.getLogger(LoggingNoLombok.class);

    public static void main(String[] args) {
        String myParameter = "PARAMETER";
        String myParemeter2 = "asdf";
        log.info("Info log {}", myParameter);
        log.warn("Warn log {}, {}", myParameter, myParemeter2);
        log.error("Error log");
        log.debug("Debug log");
    }
}
