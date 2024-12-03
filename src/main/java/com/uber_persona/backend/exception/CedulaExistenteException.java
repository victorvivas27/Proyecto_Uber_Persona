package com.uber_persona.backend.exception;

public class CedulaExistenteException extends RuntimeException {

    public CedulaExistenteException(String mensaje) {
        super(mensaje);
    }
}
