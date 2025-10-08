package com.uber_persona.backend.interfaces.viaje;

import com.uber_persona.backend.dto.entrada.ToViajeEntrada;
import com.uber_persona.backend.dto.entrada.viaje.ToViajeAsignar;
import com.uber_persona.backend.dto.entrada.viaje.ToViajeCrear;
import com.uber_persona.backend.dto.entrada.viaje.ToViajeFinalizar;
import com.uber_persona.backend.dto.salida.ToViajeSalida;

public interface IViaje {

    public ToViajeSalida crearViaje(ToViajeCrear dto);

    public ToViajeSalida asignarConductor(Long idViaje, ToViajeAsignar dto);

    ToViajeSalida iniciarViaje(Long idViaje);

    public ToViajeSalida finalizarViaje(Long idViaje, ToViajeFinalizar dto);
}
