package com.uber_persona.backend.interfaces;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;

import java.util.List;

public interface ICliente {
    ToClienteSalida crearCliente(ToClienteEntrada toClienteEntrada);

    List<ToClienteSalida> listarClientes();

    ToClienteSalida obtenerClientePorId(Long idCliente);

    ToClienteSalida actualizarCliente(ToClienteModificar toClienteModificar);

    void eliminarCliente(Long idCliente);
}
