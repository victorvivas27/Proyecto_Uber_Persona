package com.uber_persona.backend.interfaces;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.entrada.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IConductorController {
    ResponseEntity<ApiResponse<ToConductorSalida>> crearConductor( ToConductorEntrada toConductorEntrada);

    ResponseEntity<ApiResponse<List<ToConductorSalida>>> listarConductor();

    ResponseEntity<ApiResponse<ToConductorSalida>> buscarConductorID(  Long idConductor) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<ToConductorSalida>> modificarConductor(ToConductorModificar toConductorModificar) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<Long>> eliminarConductor(Long idConductor) throws ResourceNotFoundException;
}
