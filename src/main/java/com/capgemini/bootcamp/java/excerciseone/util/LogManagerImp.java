package com.capgemini.bootcamp.java.excerciseone.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogManagerImp implements LogManager{
    private final static Logger logger = Logger.getLogger(LogManagerImp.class.getName());

    public LogManagerImp(String logFile) throws IOException {
        try {
            // Configure FileHandler
            FileHandler fileHandler = new FileHandler(logFile, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Not possible to configure file handler for log", e);
            throw e;
        }
    }

    public void createLog(Level level, String action, String user) {
        // Send the log to the console
        logger.log(
                level,
                String.format(
                        """
                                --------------------------------------
                                Timestamp: %s
                                Level: %s
                                Action: %s
                                User: %s
                                --------------------------------------
                                """,
                        new java.util.Date(), // Timestamp
                        level.getName(),      // Log level
                        action,               // Action message
                        user                  //User that made the action
                )
        );
    }

}
