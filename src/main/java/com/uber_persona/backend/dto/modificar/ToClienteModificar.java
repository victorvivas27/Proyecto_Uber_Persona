package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uber_persona.backend.validation.ExactDigits;
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

    @NotNull(message = "{validation.client.cliente_id_not_null}")
    private Long idCliente;

    @NotNull(message = "{validation.persona.name.not_null}")
    @Size(min = 2, max = 50, message = "{validation.persona.name.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.persona.nombre.pattern}")
    private String nombre;

    @NotNull(message = "{validation.persona.last_name.not_null}")
    @Size(min = 2, max = 50, message = "{validation.persona.last_name.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.persona.last_name.pattern}")
    private String apellido;


    @ExactDigits(value = 8, message = "{validation.persona.cedula.size}")
    private Long cedula;

}
