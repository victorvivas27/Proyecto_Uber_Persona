package com.uber_persona.backend.exception;

public class EstadoViajeInvalidoException extends RuntimeException {
    public EstadoViajeInvalidoException(String mensaje) {
        super(mensaje);
    }
}
