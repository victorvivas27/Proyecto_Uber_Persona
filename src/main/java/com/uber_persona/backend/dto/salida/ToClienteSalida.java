package com.uber_persona.backend.dto.salida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToClienteSalida {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private Long cedula;


    @Override
    public String toString() {
        return "ToClienteSalida{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
