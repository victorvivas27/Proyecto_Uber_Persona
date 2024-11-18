package com.uber_persona.backend.service;

import com.uber_persona.backend.dto.entrada.ToConductorEntrada;
import com.uber_persona.backend.dto.modificar.ToConductorModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.entity.Conductor;
import com.uber_persona.backend.exception.CedulaExistenteException;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IConductor;
import com.uber_persona.backend.repository.ConductorRepository;
import com.uber_persona.backend.util.SalidaJson;
import com.uber_persona.backend.util.Va_Cliente;
import com.uber_persona.backend.util.Va_Conductor;
import com.uber_persona.backend.util.Va_Persona;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConductorServise  implements IConductor {
    private  final ConductorRepository conductorRepository;
    private  final ModelMapper modelMapper;
    @Override
    public ToConductorSalida crearConductor(ToConductorEntrada toConductorEntrada) {
        Long cedula = toConductorEntrada.getCedula();
        Conductor conductor = modelMapper.map(toConductorEntrada, Conductor.class);
        if (conductorRepository.existsByCedula(cedula)) {
            throw new CedulaExistenteException(Va_Persona.CEDULA_YA_EXISTE);
        }
        Conductor conductorCreado = conductorRepository.save(conductor);
        ToConductorSalida toConductorSalida = modelMapper.map(conductorCreado, ToConductorSalida.class);
        Va_Persona.info(Va_Conductor.CONDUCTOR + "\n" + SalidaJson.toString(toConductorSalida));
        return toConductorSalida;
    }

    @Override
    public List<ToConductorSalida> listarConductor() {
        return List.of();
    }

    @Override
    public ToConductorSalida obtenerConductorPorId(Long idConductor) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ToConductorSalida actualizarConductor(ToConductorModificar toConductorModificar) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void eliminarConductor(Long idConductor) throws ResourceNotFoundException {

    }
}
