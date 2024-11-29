package com.uber_persona.backend.service;

import com.uber_persona.backend.dto.entrada.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.entity.Conductor;
import com.uber_persona.backend.exception.CedulaExistenteException;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IConductor;
import com.uber_persona.backend.repository.ConductorRepository;
import com.uber_persona.backend.util.SalidaJson;
import com.uber_persona.backend.util.Va_Conductor;
import com.uber_persona.backend.util.Va_Persona;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConductorServise implements IConductor {
    private final ConductorRepository conductorRepository;
    private final ModelMapper modelMapper;
    private final ConductorServiceSave conductorRepositorySave;

    @Override
    public ToConductorSalida crearConductor(ToConductorEntrada toConductorEntrada) {
        Conductor conductor = modelMapper.map(toConductorEntrada, Conductor.class);
        Conductor conductorCreado = conductorRepositorySave.crearConductor(conductor);
        ToConductorSalida toConductorSalida = modelMapper.map(conductorCreado, ToConductorSalida.class);
        Va_Persona.info(Va_Conductor.CONDUCTOR + "\n" + SalidaJson.toString(toConductorSalida));
        return toConductorSalida;
    }

    @Override
    public List<ToConductorSalida> listarConductor() {
        List<Conductor> conductores = conductorRepository.findAll();
        return conductores.stream()
                .map(conductor -> modelMapper.map(conductor, ToConductorSalida.class)).toList();
    }

    @Override
    public ToConductorSalida obtenerConductorPorId(Long idConductor) throws ResourceNotFoundException {
        Conductor conductor = conductorRepository.findById(idConductor).orElse(null);
        ToConductorSalida toConductorSalida = null;
        if (conductor != null) {
            toConductorSalida = modelMapper.map(conductor, ToConductorSalida.class);
        } else {
            throw new ResourceNotFoundException(Va_Conductor.CONDUCTOR_ID_NO_ENCONTRADO + idConductor);
        }
        return toConductorSalida;
    }

    @Override
    public ToConductorSalida actualizarConductor(ToConductorModificar toConductorModificar) throws ResourceNotFoundException {
        Long cedula = toConductorModificar.getCedula();
        Conductor conductor = conductorRepository.findById(toConductorModificar.getIdConductor())
                .orElseThrow(() -> new ResourceNotFoundException(Va_Conductor.CONDUCTOR_ID_NO_ENCONTRADO + toConductorModificar.getIdConductor()));
        if (conductorRepository.existsByCedulaAndIdConductorNot(cedula, conductor.getIdConductor())) {
            throw new CedulaExistenteException(Va_Persona.CEDULA_YA_EXISTE);
        }
        modelMapper.map(toConductorModificar, conductor);
        conductorRepository.save(conductor);
        ToConductorSalida toConductorSalida = modelMapper.map(conductor, ToConductorSalida.class);
        Va_Persona.info(Va_Conductor.CONDUCTOR_MODIFICADO + SalidaJson.toString(toConductorSalida));
        return toConductorSalida;
    }

    @Override
    public void eliminarConductor(Long idConductor) throws ResourceNotFoundException {
        Conductor conductor = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new ResourceNotFoundException(Va_Conductor.CONDUCTOR_ID_NO_ENCONTRADO + idConductor));
        conductorRepository.deleteById(idConductor);
        Va_Persona.info(Va_Conductor.CONDUCTOR_ELIMINADO + idConductor);
    }
}
