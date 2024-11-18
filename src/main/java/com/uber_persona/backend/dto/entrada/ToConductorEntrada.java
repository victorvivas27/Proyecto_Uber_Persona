package com.uber_persona.backend.dto.entrada;

import com.uber_persona.backend.util.Va_Conductor;
import com.uber_persona.backend.util.Va_Persona;
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
    @NotNull(message = Va_Persona.NOMBRE_NOTNULL)
    @Size(min = 2, max = 50, message = Va_Persona.NOMBRE_SIZE)
    @Pattern(regexp = Va_Persona.REGEXP, message = Va_Persona.NOMBRE_PATTERN)
    private String nombre;
    @NotNull(message = Va_Persona.APELLIDO_NOTNULL)
    @Size(min = 2, max = 100, message = Va_Persona.APELLIDO_SIZE)
    @Pattern(regexp = Va_Persona.REGEXP, message = Va_Persona.APELLIDO_PATTERN)
    private String apellido;
    @NotNull(message = Va_Persona.CEDULA_NOTNULL)
    @Digits(integer = 10, fraction = 0, message = Va_Persona.NOMBRE_SIZE)
    private Long cedula;
    @NotNull(message = Va_Conductor.CONDUCTOR_LICENCIA_CONDUCIR)
    @URL(message = Va_Conductor.CONDUCTOR_LICENCIA_URL)
    private String licenciaConducir;
}
