package com.uber_persona.backend.dto.entrada.cliente;
import com.uber_persona.backend.util.Va_Persona;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ToClienteEntrada {

    @NotNull(message = Va_Persona.NOMBRE_NOT_NULL)
    @Pattern(regexp = Va_Persona.NOMBRE_REGEXP, message = Va_Persona.NOMBRE_PATTERN)
    private String nombre;

    @NotNull(message = Va_Persona.APELLIDO_NOT_NULL)
    @Pattern(regexp = Va_Persona.APELLIDO_REGEXP, message = Va_Persona.APELLIDO_PATTERN)
    private String apellido;

    @NotNull(message = Va_Persona.CEDULA_NOT_NULL)
    @Pattern(regexp = "^[0-9]+$", message = Va_Persona.CEDULA_PATTERN)
    @Size(min = 8, max = 8, message = Va_Persona.CEDULA_SIZE)
    private String cedula;

}
