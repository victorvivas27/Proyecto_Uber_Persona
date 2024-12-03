package com.uber_persona.backend.service;

import com.uber_persona.backend.constants.ConstantePersona;
import com.uber_persona.backend.entity.Conductor;
import com.uber_persona.backend.exception.CedulaExistenteException;
import com.uber_persona.backend.repository.ConductorRepository;
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
            throw new CedulaExistenteException(ConstantePersona.CEDULA_EXISTE);
        }

        Conductor conductorCreado = modelMapper.map(conductor, Conductor.class);

        return conductorRepository.save(conductorCreado);
    }
}
