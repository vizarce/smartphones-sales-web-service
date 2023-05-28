package com.vitaliy.zhakun.smartphones.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalState(IllegalStateException ex) {
        Map<String, Object> exceptionBody = new LinkedHashMap<>();
        exceptionBody.put("chronology", LocalDateTime.now());
        exceptionBody.put("statusCode", ex.getMessage().contains("does not exist") ? 404 : 400);
        exceptionBody.put("errorMessage", ex.getMessage());
        exceptionBody.put("details", ex.getLocalizedMessage());

        return new ResponseEntity<>(exceptionBody, ex.getMessage().contains("does not exist") ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST);
    }
}

