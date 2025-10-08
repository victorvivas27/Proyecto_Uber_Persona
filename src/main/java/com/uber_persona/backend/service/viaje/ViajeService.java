package com.uber_persona.backend.service.viaje;

import com.uber_persona.backend.dto.entrada.viaje.ToViajeAsignar;
import com.uber_persona.backend.dto.entrada.viaje.ToViajeCrear;
import com.uber_persona.backend.dto.entrada.viaje.ToViajeFinalizar;
import com.uber_persona.backend.dto.salida.ToViajeSalida;
import com.uber_persona.backend.entity.Conductor;
import com.uber_persona.backend.entity.Viaje;
import com.uber_persona.backend.interfaces.viaje.IViaje;
import com.uber_persona.backend.repository.ConductorRepository;
import com.uber_persona.backend.repository.ViajeRepository;
import com.uber_persona.backend.util.EstadoViaje;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class ViajeService implements IViaje {
    private final ViajeRepository viajeRepository;
    private final ModelMapper modelMapper;
    private final ViajeServiceSave viajeServiceSave;
    private final ViajeMapper viajeMapper;
    private final ConductorRepository conductorRepository;


    @Override
    public ToViajeSalida crearViaje(ToViajeCrear dto) {
        Viaje viajeCreado = viajeServiceSave.crearViaje(dto);
        return viajeMapper.toViajeSalida(viajeCreado);
    }

    public ToViajeSalida asignarConductor(Long idViaje, ToViajeAsignar dto) {
        // Buscar viaje
        Viaje viaje = viajeRepository.findById(idViaje)
                .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado con ID: " + idViaje));

        // Validar estado actual
        if (viaje.getEstado() != EstadoViaje.SOLICITADO) {
            throw new IllegalStateException("Solo se puede asignar un conductor a viajes en estado SOLICITADO");
        }

        // Buscar conductor
        Conductor conductor = conductorRepository.findById(dto.getIdConductor())
                .orElseThrow(() -> new IllegalArgumentException("Conductor no encontrado con ID: " + dto.getIdConductor()));

        // Asignar y actualizar estado
        viaje.setConductor(conductor);
        viaje.setEstado(EstadoViaje.ASIGNADO);

        // Guardar
        viajeRepository.save(viaje);

        // Devolver DTO de salida
        return viajeMapper.toViajeSalida(viaje);
    }

    public ToViajeSalida iniciarViaje(Long idViaje) {
        Viaje viaje = viajeRepository.findById(idViaje)
                .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado"));

        if (viaje.getEstado() != EstadoViaje.ASIGNADO) {
            throw new IllegalStateException("Solo se puede iniciar un viaje que esté ASIGNADO");
        }

        viaje.setEstado(EstadoViaje.EN_CURSO);
        viaje.setHoraInicio(LocalDateTime.now());

        viajeRepository.save(viaje);

        return viajeMapper.toViajeSalida(viaje);
    }

    public ToViajeSalida finalizarViaje(Long idViaje, ToViajeFinalizar dto) {
        Viaje viaje = viajeRepository.findById(idViaje)
                .orElseThrow(() -> new IllegalArgumentException("Viaje no encontrado con ID: " + idViaje));

        // Validar estado
        if (viaje.getEstado() != EstadoViaje.EN_CURSO) {
            throw new IllegalStateException("Solo se puede finalizar un viaje que esté EN_CURSO");
        }

        // Registrar fin y costo
        viaje.setHoraFin(LocalDateTime.now());
        viaje.setCosto(dto.getCosto());
        viaje.setEstado(EstadoViaje.FINALIZADO);

        viajeRepository.save(viaje);

        return viajeMapper.toViajeSalida(viaje);
    }
}
