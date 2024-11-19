package com.uber_persona.backend.dto.entrada;

import com.uber_persona.backend.util.Va_Persona;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToClienteEntrada {
    @NotNull(message = Va_Persona.NOMBRE_NOT_NULL)
    @Size(min = 2, max = 50, message = Va_Persona.NOMBRE_SIZE)
    @Pattern(regexp = Va_Persona.NOMBRE_REGEXP, message = Va_Persona.NOMBRE_PATTERN)
    private String nombre;
    @NotNull(message = Va_Persona.APELLIDO_NOT_NULL)
    @Size(min = 2, max = 100, message = Va_Persona.APELLIDO_SIZE)
    @Pattern(regexp = Va_Persona.APELLIDO_REGEXP, message = Va_Persona.APELLIDO_PATTERN)
    private String apellido;
    @NotNull(message = Va_Persona.CEDULA_NOT_NULL)
    @Digits(integer = 10, fraction = 0, message = Va_Persona.NOMBRE_SIZE)
    private Long cedula;

}
