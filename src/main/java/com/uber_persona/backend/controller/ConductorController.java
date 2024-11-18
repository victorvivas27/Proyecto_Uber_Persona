package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IConductorController;
import com.uber_persona.backend.service.ConductorServise;
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
    private final ConductorServise conductorServise;

    @Override
    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ToConductorSalida>> crearConductor(@Valid @RequestBody ToConductorEntrada toConductorEntrada) {
        ToConductorSalida toConductorSalida = conductorServise.crearConductor(toConductorEntrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(Va_Conductor.CONDUCTOR_CREADO, HttpStatus.CREATED.value(), toConductorSalida));
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<ToConductorSalida>>> listarConductor() {
        List<ToConductorSalida> toConductorSalidas = conductorServise.listarConductor();
        ApiResponse<List<ToConductorSalida>> response = new ApiResponse<>(Va_Conductor.LISTA_CONDUCTOR, HttpStatus.OK.value(), toConductorSalidas);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/buscar/{idConductor}")
    public ResponseEntity<ApiResponse<ToConductorSalida>> buscarConductorID(@PathVariable Long idConductor) throws ResourceNotFoundException {
        ToConductorSalida toConductorSalida = conductorServise.obtenerConductorPorId(idConductor);
        ApiResponse<ToConductorSalida> response = new ApiResponse<>(Va_Conductor.CONDUCTOR_ENCONTRADO, HttpStatus.OK.value(), toConductorSalida);
        return ResponseEntity.ok(response);
    }

    @Override
    @PutMapping("/modificar")
    public ResponseEntity<ApiResponse<ToConductorSalida>> modificarConductor(@Valid @RequestBody ToConductorModificar toConductorModificar) throws ResourceNotFoundException {
        ToConductorSalida toConductorSalida = conductorServise.actualizarConductor(toConductorModificar);
        ApiResponse<ToConductorSalida> response = new ApiResponse<>(Va_Conductor.CONDUCTOR_MODIFICADO, HttpStatus.OK.value(), toConductorSalida);
        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/eliminar/{idConductor}")
    public ResponseEntity<ApiResponse<Long>> eliminarConductor(@PathVariable Long idConductor) throws ResourceNotFoundException {
        conductorServise.eliminarConductor(idConductor);
        ApiResponse<Long> response = new ApiResponse<>(Va_Conductor.CONDUCTOR_ELIMINADO, HttpStatus.OK.value(), idConductor);
        return ResponseEntity.ok(response);
    }
}
