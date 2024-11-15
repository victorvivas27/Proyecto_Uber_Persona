package com.uber_persona.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Va {
    public static final String NOMBRE = "NOMBRE";
    public static final String APELLIDO = "APELLIDO";
    public static final String CEDULA = "CEDULA";
    public static final String CLIENTE_CREADO = "Cliente Creado";
    public static final String LISTA_CLIENTE = "Lista de clientes exitosa";
    public static final String CLIENTE_ENCONTRADO = "Cliente encontrado";
    public static final String CLIENTE_MODIFICADO = "Cliente modificado";
    public static final String CLIENTE_ELIMINADO = "Cliente eliminado";
    private static final Logger LOGGER = LoggerFactory.getLogger("ApplicationLogger");

    public static void info(String message) {
        LOGGER.info(message);
    }
}