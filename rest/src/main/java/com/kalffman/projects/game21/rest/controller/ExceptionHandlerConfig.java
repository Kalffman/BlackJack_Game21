package com.kalffman.projects.game21.rest.controller;

import com.kalffman.projects.game21.input.exception.InputException;
import com.kalffman.projects.game21.rest.controller.dto.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler({InputException.class})
    public ResponseEntity<?> handleInputException(InputException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new ApiError(ex.getCode(), ex.getMessage()));
    }
}
