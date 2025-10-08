package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.conductor.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IConductorController;
import com.uber_persona.backend.service.ConductorService;
import com.uber_persona.backend.util.ApiResponse;
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
    private final ConductorService conductorServise;

    @Override
    @PostMapping()
    public ResponseEntity<ApiResponse<ToConductorSalida>> crearConductor(@Valid @RequestBody ToConductorEntrada toConductorEntrada) {
        ToConductorSalida toConductorSalida = conductorServise.crearConductor(toConductorEntrada);
        return ApiResponse.build(Va_Conductor.CONDUCTOR_CREADO, HttpStatus.CREATED, toConductorSalida);
    }

    @Override
    @GetMapping()
    public ResponseEntity<ApiResponse<List<ToConductorSalida>>> listarConductor() {
        List<ToConductorSalida> toConductorSalidas = conductorServise.listarConductor();
        return ApiResponse.build(Va_Conductor.LISTA_CONDUCTOR, HttpStatus.OK, toConductorSalidas);

    }

    @Override
    @GetMapping("/{idConductor}")
    public ResponseEntity<ApiResponse<ToConductorSalida>> buscarConductorID(@PathVariable Long idConductor)
            throws ResourceNotFoundException {

        ToConductorSalida toConductorSalida = conductorServise.obtenerConductorPorId(idConductor);
        return ApiResponse.build(Va_Conductor.CONDUCTOR_ENCONTRADO, HttpStatus.OK, toConductorSalida);

    }

    @Override
    @PutMapping()
    public ResponseEntity<ApiResponse<ToConductorSalida>> modificarConductor(@Valid @RequestBody ToConductorModificar toConductorModificar)
            throws ResourceNotFoundException {

        ToConductorSalida toConductorSalida = conductorServise.actualizarConductor(toConductorModificar);
        return ApiResponse.build(Va_Conductor.CONDUCTOR_MODIFICADO, HttpStatus.OK, toConductorSalida);

    }

    @Override
    @DeleteMapping("/{idConductor}")
    public ResponseEntity<ApiResponse<Long>> eliminarConductor(@PathVariable Long idConductor)
            throws ResourceNotFoundException {

        conductorServise.eliminarConductor(idConductor);
        return ApiResponse.build(Va_Conductor.CONDUCTOR_ELIMINADO, HttpStatus.OK, idConductor);

    }
}
