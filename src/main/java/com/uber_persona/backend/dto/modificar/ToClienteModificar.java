package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @NotNull(message = "El idCliente es obligatorio")
    private Long idCliente;
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre {min} y {max} caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "El nombre solo debe contener letras, acentos y espacios")
    private String nombre;
    @NotNull(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre {min} y {max} caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "El apellido solo debe contener letras, acentos y espacios")
    private String apellido;
    @NotNull(message = "La cédula es obligatoria")
    @Digits(integer = 10, fraction = 0, message = "La cédula debe tener entre 9 y 10 dígitos numéricos")
    private Long cedula;

}
