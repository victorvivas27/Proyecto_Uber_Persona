package com.uber_persona.backend.dto.salida;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToClienteSalida {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String cedula;

}
