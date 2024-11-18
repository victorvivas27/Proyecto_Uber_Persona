package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IConductorController;
import com.uber_persona.backend.service.ConductorServise;
import com.uber_persona.backend.util.ApiResponse;
import com.uber_persona.backend.util.Va_Cliente;
import com.uber_persona.backend.util.Va_Conductor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/conductor")
public class ConductorController implements IConductorController {
    private  final ConductorServise conductorServise;
    @Override
    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ToConductorSalida>> crearConductor( @Valid @RequestBody ToConductorEntrada toConductorEntrada) {
        ToConductorSalida toConductorSalida = conductorServise.crearConductor(toConductorEntrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(Va_Conductor.CONDUCTOR_CREADO, HttpStatus.CREATED.value(), toConductorSalida));
    }

    @Override
    public ResponseEntity<ApiResponse<List<ToConductorSalida>>> listarConductor() {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<ToConductorSalida>> buscarConductorID(Long idConductor) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<ToConductorSalida>> modificarConductor(ToConductorModificar toConductorModificar) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Long>> eliminarConductor(Long idConductor) throws ResourceNotFoundException {
        return null;
    }
}
