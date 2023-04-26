package com.example.swmini.advice;

import com.example.swmini.exception.PostNotFoundException;
import com.example.swmini.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.swmini.advice.ErrorCode.POST_NOT_FOUND;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlePostNotFoundException(PostNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(POST_NOT_FOUND.getCode(), POST_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
