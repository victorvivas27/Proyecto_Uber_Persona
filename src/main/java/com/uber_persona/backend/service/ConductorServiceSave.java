package com.uber_persona.backend.service;

import com.uber_persona.backend.entity.Conductor;
import com.uber_persona.backend.exception.CedulaExistenteException;
import com.uber_persona.backend.repository.ConductorRepository;
import com.uber_persona.backend.util.Va_Persona;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConductorServiceSave {
    private final ConductorRepository conductorRepository;
    private final ModelMapper modelMapper;

    public Conductor crearConductor(Conductor conductor) {
        Long cedula = conductor.getCedula();
        if (conductorRepository.existsByCedula(cedula)) {
            throw new CedulaExistenteException(Va_Persona.CEDULA_YA_EXISTE);
        }
        Conductor conductorCreado = modelMapper.map(conductor, Conductor.class);
        return conductorRepository.save(conductorCreado);
    }
}
