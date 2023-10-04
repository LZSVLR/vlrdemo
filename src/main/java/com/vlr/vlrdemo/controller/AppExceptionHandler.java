package com.vlr.vlrdemo.controller;


import com.vlr.vlrdemo.entity.PaymentStatus;
import com.vlr.vlrdemo.exception.ApiError;
import com.vlr.vlrdemo.exception.CreateValidationException;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

// старый
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CreateValidationException.class)
    public ResponseEntity<Object> handleClientNameIsNull(CreateValidationException e)
    {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(DataNotFoundException e)
    {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
//    @ResponseBody
//    public Object handleBadRequestException(HttpClientErrorException.BadRequest e) {
//        PaymentStatus response = e.getResponseBodyAs(PaymentStatus.class);
//        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//    }

}
