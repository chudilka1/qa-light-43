package ua.alexyepishev.tests.loggers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingWithLombok {
    public static void main(String[] args) {
        String myParameter = "PARAMETER";
        String myParemeter2 = "asdf";
        log.info("Info log {}", myParameter);
        log.warn("Warn log {}, {}", myParameter, myParemeter2);
        log.error("Error log");
        log.debug("Debug log");
    }
}
