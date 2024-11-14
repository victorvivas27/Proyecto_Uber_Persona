package com.uber_persona.backend.exception;

import com.uber_persona.backend.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeceptionHandler {


    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<String> manejarResourceNotFound(ResourceNotFoundException exception) {
        return new ApiResponse<>(exception.getMessage(), HttpStatus.NOT_FOUND.value(), null);
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Map<String, String>> procesarValidacionException(MethodArgumentNotValidException exception) {
        Map<String, String> errorMessages = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMessages.put(fieldName, errorMessage);
        });

        return new ApiResponse<>("Errores de validación", HttpStatus.BAD_REQUEST.value(), errorMessages);
    }
    @ExceptionHandler(ClienteExistenteException.class)
    public ResponseEntity<ApiResponse<String>> handleDuplicateEmailException(ClienteExistenteException e) {
        ApiResponse<String> response = new ApiResponse<>(e.getMessage(), HttpStatus.BAD_REQUEST.value(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
