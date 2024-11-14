package com.uber_persona.backend.dto.modificar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Pattern(regexp = "^[0-9]{9,10}$", message = "La cédula debe tener entre 9 y 10 dígitos numéricos")
    private Long cedula;

    public ToClienteModificar(Long idCliente, String nombre, String apellido, Long cedula) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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