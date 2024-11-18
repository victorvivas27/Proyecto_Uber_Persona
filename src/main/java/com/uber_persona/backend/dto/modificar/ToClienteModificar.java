package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uber_persona.backend.util.Va_Cliente;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToClienteModificar {
    @NotNull(message = Va_Cliente.CLIENTE_ID_NOTNULL)
    private Long idCliente;
    @NotNull(message = Va_Persona.NOMBRE_NOTNULL)
    @Size(min = 2, max = 50, message = Va_Persona.NOMBRE_SIZE)
    @Pattern(regexp = Va_Persona.REGEXP, message = Va_Persona.NOMBRE_PATTERN)
    private String nombre;
    @NotNull(message = Va_Persona.APELLIDO_NOTNULL)
    @Size(min = 2, max = 100, message = Va_Persona.APELLIDO_SIZE)
    @Pattern(regexp = Va_Persona.REGEXP, message = Va_Persona.APELLIDO_PATTERN)
    private String apellido;
    @NotNull(message = Va_Persona.CEDULA_NOTNULL)
    @Digits(integer = 10, fraction = 0, message = Va_Persona.CEDULA_SIZE)
    private Long cedula;

}
