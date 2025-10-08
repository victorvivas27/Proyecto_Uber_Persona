package com.uber_persona.backend.interfaces.viaje;


import com.uber_persona.backend.dto.entrada.viaje.*;
import com.uber_persona.backend.dto.salida.ToViajeSalida;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Interface que define el contrato del controlador de viajes.
 * Cada método representa una etapa del ciclo de vida de un viaje.
 */
@RequestMapping("api/viajes")
public interface IViajeController {


    /**
     * Crear un nuevo viaje.
     * Estado inicial: SOLICITADO.
     */
    @PostMapping
    ResponseEntity<ApiResponse<ToViajeSalida>> crearViaje(
            @Valid @RequestBody ToViajeCrear toViajeCrear);

    /**
     * Asignar un conductor a un viaje existente.
     * Estado actual requerido: SOLICITADO.
     */
    @PutMapping("/{idViaje}/asignar")
    ResponseEntity<ApiResponse<ToViajeSalida>> asignarConductor(
            @PathVariable Long idViaje,
            @Valid @RequestBody ToViajeAsignar toViajeAsignar);

    /**
     * Iniciar un viaje asignado.
     * Estado actual requerido: ASIGNADO.
     */
    @PutMapping("/{idViaje}/iniciar")
    ResponseEntity<ApiResponse<ToViajeSalida>> iniciarViaje(
            @PathVariable Long idViaje,
            @Valid @RequestBody ToViajeIniciar toViajeIniciar);

    /**
     * Finalizar un viaje en curso.
     * Estado actual requerido: EN_CURSO.
     */
    @PutMapping("/{idViaje}/finalizar")
    ResponseEntity<ApiResponse<ToViajeSalida>> finalizarViaje(
            @PathVariable Long idViaje,
            @Valid @RequestBody ToViajeFinalizar toViajeFinalizar);

    /**
     * Cancelar un viaje.
     * Estados permitidos: SOLICITADO o ASIGNADO.
     */
    @PutMapping("/{idViaje}/cancelar")
    ResponseEntity<ApiResponse<ToViajeSalida>> cancelarViaje(
            @PathVariable Long idViaje,
            @Valid @RequestBody ToViajeCancelar toViajeCancelar);
}