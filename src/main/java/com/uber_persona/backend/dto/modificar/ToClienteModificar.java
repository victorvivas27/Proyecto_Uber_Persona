package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uber_persona.backend.util.Va;
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
    @NotNull(message = Va.CLIENTE_ID_NOTNULL)
    private Long idCliente;
    @NotNull(message = Va.NOMBRE_NOTNULL)
    @Size(min = 2, max = 50, message = Va.NOMBRE_SIZE)
    @Pattern(regexp = Va.CLIENTE_REGEXP, message = Va.NOMBRE_PATTERN )
    private String nombre;
    @NotNull(message = Va.APELLIDO_NOTNULL)
    @Size(min = 2, max = 100, message = Va.APELLIDO_SIZE)
    @Pattern(regexp = Va.CLIENTE_REGEXP, message = Va.APELLIDO_PATTERN)
    private String apellido;
    @NotNull(message = Va.CEDULA_NOTNULL)
    @Digits(integer = 10, fraction = 0, message = Va.CEDULA_SIZE)
    private Long cedula;

}
