package com.uber_persona.backend.dto.entrada;

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
public class ToConductorEntrada {
    @NotNull(message = ConstantesPersona.NOMBRE_NOT_NULL)
    @Size(min = 2, max = 50, message = ConstantesPersona.NOMBRE_SIZE)
    @Pattern(regexp = ConstantesPersona.NOMBRE_REGEXP, message = ConstantesPersona.NOMBRE_PATTERN)
    private String nombre;
    @NotNull(message = ConstantesPersona.APELLIDO_NOT_NULL)
    @Size(min = 2, max = 100, message = ConstantesPersona.APELLIDO_SIZE)
    @Pattern(regexp = ConstantesPersona.APELLIDO_REGEXP, message = ConstantesPersona.APELLIDO_PATTERN)
    private String apellido;
    @NotNull(message = ConstantesPersona.CEDULA_NOT_NULL)
    @Digits(integer = 10, fraction = 0, message = ConstantesPersona.NOMBRE_SIZE)
    private Long cedula;
    @NotNull(message = ConstantesConductor.CONDUCTOR_LICENCIA_CONDUCIR)
    @URL(message = ConstantesConductor.CONDUCTOR_LICENCIA_URL)
    private String licenciaConducir;
}
