package com.uber_persona.backend.interfaces;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;

import java.util.List;

public interface ICliente {
    ToClienteSalida crearCliente(ToClienteEntrada toClienteEntrada);

    List<ToClienteSalida> listarClientes();

    ToClienteSalida obtenerClientePorId(Long idCliente) throws ResourceNotFoundException;

    ToClienteSalida actualizarCliente(ToClienteModificar toClienteModificar) throws ResourceNotFoundException;

    void eliminarCliente(Long idCliente) throws ResourceNotFoundException;
}