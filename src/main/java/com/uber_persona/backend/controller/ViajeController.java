package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.viaje.*;
import com.uber_persona.backend.dto.salida.ToViajeSalida;
import com.uber_persona.backend.interfaces.viaje.IViajeController;
import com.uber_persona.backend.service.viaje.ViajeService;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor

public class ViajeController implements IViajeController {
    private final ViajeService viajeService;

    @Override
    public ResponseEntity<ApiResponse<ToViajeSalida>> crearViaje(@Valid @RequestBody ToViajeCrear toViajeCrear) {
        ToViajeSalida toViajeSalida = viajeService.crearViaje(toViajeCrear);
        return ApiResponse.build("Viaje creado", HttpStatus.CREATED, toViajeSalida);
    }


    @Override
    public ResponseEntity<ApiResponse<ToViajeSalida>> asignarConductor(Long idViaje, ToViajeAsignar toViajeAsignar) {
        ToViajeSalida toViajeSalida = viajeService.asignarConductor(idViaje, toViajeAsignar);
        return ApiResponse.build("Conductor asignado correctamente", HttpStatus.OK, toViajeSalida);
    }

    @Override
    public ResponseEntity<ApiResponse<ToViajeSalida>> iniciarViaje(Long idViaje, ToViajeIniciar toViajeIniciar) {
        ToViajeSalida toViajeSalida = viajeService.iniciarViaje(idViaje);
        return ApiResponse.build("El viaje se inicio ", HttpStatus.OK, toViajeSalida);
    }

    @Override
    public ResponseEntity<ApiResponse<ToViajeSalida>> finalizarViaje(Long idViaje, ToViajeFinalizar toViajeFinalizar) {
        ToViajeSalida toViajeSalida = viajeService.finalizarViaje(idViaje, toViajeFinalizar);
        return ApiResponse.build("Viaje finalizado", HttpStatus.OK, toViajeSalida);
    }

    @Override
    public ResponseEntity<ApiResponse<ToViajeSalida>> cancelarViaje(Long idViaje, ToViajeCancelar toViajeCancelar) {
        return null;
    }
}
