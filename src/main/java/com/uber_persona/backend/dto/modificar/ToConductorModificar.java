package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToConductorModificar {
    @NotNull(message = Va_Conductor.CONDUCTOR_ID_NOT_NULL)
    private Long idConductor;
    @NotNull(message = Va_Persona.NOMBRE_NOT_NULL)
    @Size(min = 2, max = 50, message = Va_Persona.NOMBRE_SIZE)
    @Pattern(regexp = Va_Persona.NOMBRE_REGEXP, message = Va_Persona.NOMBRE_PATTERN)
    private String nombre;
    @NotNull(message = Va_Persona.APELLIDO_NOT_NULL)
    @Size(min = 2, max = 100, message = Va_Persona.APELLIDO_SIZE)
    @Pattern(regexp = Va_Persona.APELLIDO_REGEXP, message = Va_Persona.APELLIDO_PATTERN)
    private String apellido;

    @Digits(integer = 10, fraction = 0, message = Va_Persona.CEDULA_SIZE)
    private Long cedula;
    @NotNull(message = Va_Conductor.CONDUCTOR_LICENCIA_CONDUCIR)
    @URL(message = Va_Conductor.CONDUCTOR_LICENCIA_URL)
    private String licenciaConducir;
}
