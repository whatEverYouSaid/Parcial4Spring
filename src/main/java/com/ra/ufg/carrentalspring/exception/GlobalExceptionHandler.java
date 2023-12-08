package com.ra.ufg.carrentalspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UnavailableCarException.class})
    public ResponseEntity<Object> handleCustomForbiddenException(Exception e, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                request.getDescription(false), ZonedDateTime.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);

    }
}
