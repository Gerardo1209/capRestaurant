package com.capgemini.bootcamp.java.excerciseone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    public static class ErrorResponse{
        private int status;
        private String message;
        private long timeStamp;

        public ErrorResponse(
                int status,
                String message,
                long timeStamp
        ){
            this.status = status;
            this.message = message;
            this.timeStamp = timeStamp;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public long getTimeStamp() {
            return timeStamp;
        }
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
