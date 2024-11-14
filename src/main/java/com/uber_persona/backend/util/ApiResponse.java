package com.uber_persona.backend.util;

public class ApiResponse<T> {
    private String message;
    private int status;
    private T data;

    public ApiResponse(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
