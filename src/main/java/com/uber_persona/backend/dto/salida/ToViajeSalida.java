package com.uber_persona.backend.dto.salida;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.uber_persona.backend.util.EstadoViaje;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToViajeSalida {

    private Long idViaje;
    private ToClienteSalida cliente;
    private ToConductorSalida conductor;
    private String puntoInicio;
    private String destino;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Santiago")
    private LocalDateTime horaInicio;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Santiago")
    private LocalDateTime horaFin;
    private Double costo;
    private EstadoViaje estado;
}
