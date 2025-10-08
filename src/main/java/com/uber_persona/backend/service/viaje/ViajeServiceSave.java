package com.uber_persona.backend.service.viaje;

import com.uber_persona.backend.dto.entrada.viaje.ToViajeCrear;
import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.entity.Viaje;
import com.uber_persona.backend.exception.EntidadNoEncontradaException;
import com.uber_persona.backend.repository.ClienteRepository;
import com.uber_persona.backend.repository.ConductorRepository;
import com.uber_persona.backend.repository.ViajeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ViajeServiceSave {
    private final ViajeRepository viajeRepository;
    private final ClienteRepository clienteRepository;
    private final ConductorRepository conductorRepository;
    private final ModelMapper modelMapper;

    public Viaje crearViaje(ToViajeCrear dto) {

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntidadNoEncontradaException("Cliente no encontrado"));

//        Conductor conductor = conductorRepository.findById(dto.getIdConductor())
//                .orElseThrow(() -> new EntidadNoEncontradaException("Conductor no encontrado"));

        Viaje viaje = Viaje.builder()
                .cliente(cliente)
                .puntoInicio(dto.getPuntoInicio())
                .destino(dto.getDestino())
                .estado(dto.getEstado())
                .build();
        return viajeRepository.save(viaje);
    }
}
