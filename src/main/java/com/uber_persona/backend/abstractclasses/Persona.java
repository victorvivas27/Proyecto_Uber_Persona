package com.uber_persona.backend.abstractclasses;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    @Column(name = "APELLIDO", length = 100, nullable = false)
    private String apellido;
    @Column(name = "CEDULA", length = 15, nullable = false, unique = true)
    private Long cedula;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCliente() {
        return idCliente;
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
