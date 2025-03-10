package com.capgemini.bootcamp.java.excerciseone.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class LogConfigurationTest {

    @Test
    void createLogManager() {
        LogConfiguration logConfiguration = new LogConfiguration();
        assertNull(logConfiguration.processLog("bad/path/to/file.txt"));
    }
}