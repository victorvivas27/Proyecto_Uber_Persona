package com.uber_persona.backend.exception;

public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String mensaje) {
        super(mensaje);
    }
}
