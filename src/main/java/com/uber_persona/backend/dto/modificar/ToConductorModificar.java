package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uber_persona.backend.util.ConstantesConductor;
import com.uber_persona.backend.util.ConstantesPersona;
import jakarta.validation.constraints.Digits;
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
    @NotNull(message = ConstantesConductor.CONDUCTOR_LICENCIA_CONDUCIR)
    @URL(message = ConstantesConductor.CONDUCTOR_LICENCIA_URL)
    private String licenciaConducir;
}
