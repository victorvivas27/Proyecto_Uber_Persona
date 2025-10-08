package com.uber_persona.backend.dto.entrada.viaje;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToViajeAsignar {

    @NotNull(message = "El ID del conductor es obligatorio")
    private Long idConductor;
}
