package com.example.demoCRUD.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {

    @ExceptionHandler
    ResponseEntity<UserErrorResponse> exceptionHandler(Exception e){
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        userErrorResponse.setMessage(e.getMessage());
        userErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
