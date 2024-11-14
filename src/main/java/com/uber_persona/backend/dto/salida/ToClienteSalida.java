package com.uber_persona.backend.dto.salida;

public class ToClienteSalida {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private Long cedula;

    public ToClienteSalida(Long idCliente, String nombre, String apellido, Long cedula) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public ToClienteSalida() {
    }

    public Long getIdCliente() {
        return idCliente;
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

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
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
