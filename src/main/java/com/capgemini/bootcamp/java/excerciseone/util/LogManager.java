package com.capgemini.bootcamp.java.excerciseone.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogManager {
    private final static Logger logger = Logger.getLogger(LogManager.class.getName());

    public LogManager(String logFile){
        try {
            // Configure FileHandler
            FileHandler fileHandler = new FileHandler(logFile, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Not possible to configure file handler for log", e);
        }
    }

    public void createLog(Level level, String action) {
        // Send the log to the console
        logger.log(
                level,
                String.format(
                        """
                                --------------------------------------
                                Timestamp: %s
                                Level: %s
                                Action: %s
                                --------------------------------------
                                """,
                        new java.util.Date(), // Timestamp
                        level.getName(),      // Log level
                        action               // Action message
                )
        );
    }

}
