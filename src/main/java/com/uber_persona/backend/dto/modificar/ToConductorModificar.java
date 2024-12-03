package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uber_persona.backend.constants.ConstantesConductor;
import com.uber_persona.backend.validation.ExactDigits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToConductorModificar {

    @NotNull(message = ConstantesConductor.CONDUCTOR_ID_NOT_NULL)
    private Long idConductor;

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

    @NotNull(message = "{validation.conductor.licencia.not_null}")
    @URL(message = "{validation.conductor.licencia.url}")
    @Size(max = 240, message = "{validation.conductor.licencia.url.size}")
    private String licenciaConducir;
}
