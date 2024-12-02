package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uber_persona.backend.util.ConstantesCliente;
import com.uber_persona.backend.util.ConstantesPersona;
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
    @NotNull(message = ConstantesCliente.CLIENTE_ID_NOTNULL)
    private Long idCliente;
    @NotNull(message = ConstantesPersona.NOMBRE_NOT_NULL)
    @Size(min = 2, max = 50, message = ConstantesPersona.NOMBRE_SIZE)
    @Pattern(regexp = ConstantesPersona.NOMBRE_REGEXP, message = ConstantesPersona.NOMBRE_PATTERN)
    private String nombre;
    @NotNull(message = ConstantesPersona.APELLIDO_NOT_NULL)
    @Size(min = 2, max = 100, message = ConstantesPersona.APELLIDO_SIZE)
    @Pattern(regexp = ConstantesPersona.APELLIDO_REGEXP, message = ConstantesPersona.APELLIDO_PATTERN)
    private String apellido;

    @Digits(integer = 10, fraction = 0, message = ConstantesPersona.CEDULA_SIZE)
    private Long cedula;

}
