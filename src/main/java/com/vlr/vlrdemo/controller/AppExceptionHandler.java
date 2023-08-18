package com.vlr.vlrdemo.controller;


import com.vlr.vlrdemo.exception.ApiError;
import com.vlr.vlrdemo.exception.CreateValidationException;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

// старый
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CreateValidationException.class)
    public ResponseEntity<Object> handleClientNameIsNull(CreateValidationException e)
    {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.I_AM_A_TEAPOT, LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(DataNotFoundException e)
    {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.I_AM_A_TEAPOT, LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }
}
