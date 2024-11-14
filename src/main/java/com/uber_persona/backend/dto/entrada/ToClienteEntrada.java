package com.uber_persona.backend.dto.entrada;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class ToClienteEntrada {
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

    public ToClienteEntrada(String apellido, String nombre, Long cedula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public ToClienteEntrada() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
}
