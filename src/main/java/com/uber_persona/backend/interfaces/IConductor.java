package com.uber_persona.backend.interfaces;

import com.uber_persona.backend.dto.entrada.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;

import java.util.List;

public interface IConductor {
    ToConductorSalida crearConductor(ToConductorEntrada toConductorEntrada);

    List<ToConductorSalida> listarConductor();

    ToConductorSalida obtenerConductorPorId(Long idConductor) throws ResourceNotFoundException;

    ToConductorSalida actualizarConductor(ToConductorModificar toConductorModificar) throws ResourceNotFoundException;

    void eliminarConductor(Long idConductor) throws ResourceNotFoundException;
}
