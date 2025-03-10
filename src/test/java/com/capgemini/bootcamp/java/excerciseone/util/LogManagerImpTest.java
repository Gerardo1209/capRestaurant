package com.capgemini.bootcamp.java.excerciseone.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LogManagerImpTest {
    @Spy
    LogManager logManager;

    @Test
    void createLog() throws IOException {
        LogManager logManager = new LogManagerImp("test.log");
        logManager.createLog(Level.INFO, "Test", "Test");
    }

    @Test
    void createLogException() {
        assertThrows(Exception.class, () -> new LogManagerImp("invalid/path/to/file/test.log"));
    }
}