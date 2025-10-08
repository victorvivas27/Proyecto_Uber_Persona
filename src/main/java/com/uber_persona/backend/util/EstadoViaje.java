package com.uber_persona.backend.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.uber_persona.backend.exception.EstadoViajeInvalidoException;

public enum EstadoViaje {
    SOLICITADO,
    ASIGNADO,
    EN_CURSO,
    FINALIZADO,
    CANCELADO;
    @JsonCreator
    public static EstadoViaje fromString(String value) {
        for (EstadoViaje estado : EstadoViaje.values()) {
            if (estado.name().equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new EstadoViajeInvalidoException(
                "Estado de viaje inválido: " + value + " Debe ser uno de: SOLICITADO, EN_CURSO, FINALIZADO o CANCELADO."
        );
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
