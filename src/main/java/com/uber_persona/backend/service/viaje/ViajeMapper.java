package com.uber_persona.backend.service.viaje;

import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.dto.salida.ToConductorSalida;
import com.uber_persona.backend.dto.salida.ToViajeSalida;
import com.uber_persona.backend.entity.Viaje;
import org.springframework.stereotype.Component;

@Component
public class ViajeMapper {

    public ToViajeSalida toViajeSalida(Viaje viaje) {

        ToClienteSalida clienteSalida = ToClienteSalida.builder()
                .idCliente(viaje.getCliente().getIdCliente())
                .nombre(viaje.getCliente().getNombre())
                .apellido(viaje.getCliente().getApellido())
                .build();

        ToConductorSalida conductorSalida = null;
        if (viaje.getConductor() != null) {
            conductorSalida = ToConductorSalida.builder()
                    .idConductor(viaje.getConductor().getIdConductor())
                    .nombre(viaje.getConductor().getNombre())
                    .apellido(viaje.getConductor().getApellido())
                    .build();
        }

        ToViajeSalida viajeSalida = ToViajeSalida.builder()
                .idViaje(viaje.getIdViaje())
                .cliente(clienteSalida)
                .conductor(conductorSalida)
                .puntoInicio(viaje.getPuntoInicio())
                .destino(viaje.getDestino())
                .horaInicio(viaje.getHoraInicio())
                .horaFin(viaje.getHoraFin())
                .costo(viaje.getCosto())
                .estado(viaje.getEstado())
                .build();

        return viajeSalida;


    }

}