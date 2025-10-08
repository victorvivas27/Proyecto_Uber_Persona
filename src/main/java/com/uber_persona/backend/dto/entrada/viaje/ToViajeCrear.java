package com.uber_persona.backend.dto.entrada.viaje;

import com.uber_persona.backend.util.EstadoViaje;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToViajeCrear {
    // 🔹 CLIENTE
    @NotNull(message = "El idCliente es obligatorio")
    private Long idCliente;

    // 🔹 PUNTO DE INICIO
    @NotBlank(message = "El punto de inicio no puede estar vacío")
    @Size(min = 3, max = 100, message = "El punto de inicio debe tener entre 3 y 100 caracteres")
    private String puntoInicio;

    // 🔹 DESTINO
    @NotBlank(message = "El destino no puede estar vacío")
    @Size(min = 3, max = 100, message = "El destino debe tener entre 3 y 100 caracteres")
    private String destino;

    // 🔹 ESTADO
    @NotNull(message = "El estado del viaje no puede ser nulo")
    private EstadoViaje estado;
}
