package com.uber_persona.backend.dto.entrada.viaje;

import com.uber_persona.backend.util.EstadoViaje;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToViajeEntrada {
    // 🔹 CLIENTE
    @NotNull(message = "El idCliente es obligatorio")

    private Long idCliente;

    // 🔹 CONDUCTOR
    @NotNull(message = "El idConductor es obligatorio")

    private Long idConductor;

    // 🔹 PUNTO DE INICIO
    @NotBlank(message = "El punto de inicio no puede estar vacío")
    @Size(min = 3, max = 100, message = "El punto de inicio debe tener entre 3 y 100 caracteres")
    private String puntoInicio;

    // 🔹 DESTINO
    @NotBlank(message = "El destino no puede estar vacío")
    @Size(min = 3, max = 100, message = "El destino debe tener entre 3 y 100 caracteres")
    private String destino;

    // 🔹 HORA DE FIN
    @NotNull(message = "La hora de finalización es obligatoria")
    @Future(message = "La hora de fin debe ser una fecha futura")
    private LocalDateTime horaFin;

    // 🔹 COSTO
    @NotNull(message = "El costo es obligatorio")
    @Positive(message = "El costo debe ser mayor que 0")
    @Digits(integer = 6, fraction = 2, message = "El costo debe tener hasta 6 dígitos enteros y 2 decimales")
    private Double costo;

    // 🔹 ESTADO
    @NotNull(message = "El estado del viaje no puede ser nulo")
    private EstadoViaje estado;
}
