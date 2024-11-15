package com.uber_persona.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Va {
    public static final String NOMBRE = "NOMBRE";
    public static final String APELLIDO = "APELLIDO";
    public static final String CEDULA = "CEDULA";
    private static final Logger LOGGER = LoggerFactory.getLogger("ApplicationLogger");

    public static void info(String message) {
        LOGGER.info(message);
    }
}
