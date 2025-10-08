package com.uber_persona.backend.dto.salida;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToConductorSalida {
    private Long idConductor;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String licenciaConducir;
}
