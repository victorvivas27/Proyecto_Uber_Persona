package com.uber_persona.backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private String message;
    private int status;
    private T data;

    // ✅ Método estático para construir la ResponseEntity
    public static <T> ResponseEntity<ApiResponse<T>> build(String message, HttpStatus status, T data) {
        ApiResponse<T> response = new ApiResponse<>(message, status.value(), data);
        return ResponseEntity.status(status).body(response);
    }

}
