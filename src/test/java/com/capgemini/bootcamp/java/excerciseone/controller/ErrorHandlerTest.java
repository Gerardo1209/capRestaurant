package com.capgemini.bootcamp.java.excerciseone.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {

    private final String ERROR_MESSAGE = "Test exception";

    @Test
    void handleException() {
        ErrorHandler errorHandler = new ErrorHandler();
        var testErrorHandler = errorHandler.handleException(new IllegalArgumentException(ERROR_MESSAGE));
        assertEquals(ERROR_MESSAGE, Objects.requireNonNull(testErrorHandler.getBody()).getMessage());
    }

    @Test
    void errorCase() {
        long time = System.currentTimeMillis();
        ErrorHandler.ErrorResponse errorResponse = new ErrorHandler.ErrorResponse(HttpStatus.BAD_REQUEST.value(), ERROR_MESSAGE, time);
        assertEquals(ERROR_MESSAGE, errorResponse.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST.value(), errorResponse.getStatus());
        assertEquals(time, errorResponse.getTimeStamp());
    }
}