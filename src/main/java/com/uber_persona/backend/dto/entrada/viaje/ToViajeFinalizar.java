package com.uber_persona.backend.dto.entrada.viaje;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToViajeFinalizar {

    // 🔹 COSTO
    @NotNull(message = "El costo es obligatorio")
    @Positive(message = "El costo debe ser mayor que 0")
    @Digits(integer = 6, fraction = 2, message = "El costo debe tener hasta 6 dígitos enteros y 2 decimales")
    private Double costo;
}
