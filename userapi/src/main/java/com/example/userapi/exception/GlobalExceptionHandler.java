package com.example.userapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
        public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExistsException ex){
            return ResponseEntity.status(409).body(ex.getMessage());
        }

}
