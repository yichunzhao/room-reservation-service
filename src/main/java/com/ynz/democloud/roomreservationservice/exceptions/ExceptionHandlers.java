package com.ynz.democloud.roomreservationservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(InvalidDateFormat.class)
    public ResponseEntity<String> handleIllegalArgumentException(InvalidDateFormat e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
