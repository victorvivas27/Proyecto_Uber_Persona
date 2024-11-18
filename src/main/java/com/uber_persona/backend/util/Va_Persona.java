package com.uber_persona.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Va_Persona {
    public static final String NOMBRE_NOTNULL = "El nombre es obligatorio";
    public static final String NOMBRE_SIZE = "El nombre debe tener entre {min} y {max} caracteres";
    public static final String NOMBRE_PATTERN = "El nombre solo debe contener letras, acentos y espacios";
    public static final String APELLIDO_NOTNULL = "El apellido es obligatorio";
    public static final String APELLIDO_SIZE = "El apellido debe tener entre {min} y {max} caracteres";
    public static final String APELLIDO_PATTERN = "El apellido solo debe contener letras, acentos y espacios";
    public static final String CEDULA_NOTNULL = "La cédula es obligatoria";
    public static final String CEDULA_SIZE = "La cédula debe tener entre 9 y 10 dígitos numéricos";
    public static final String REGEXP = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$";
    public static final String NOMBRE = "NOMBRE";
    public static final String APELLIDO = "APELLIDO";
    public static final String CEDULA = "CEDULA";
    public static final String CEDULA_YA_EXISTE = "La cédula ya existe en el sistema";
    private static final Logger LOGGER = LoggerFactory.getLogger("ApplicationLogger");

    public static void info(String message) {
        LOGGER.info(message);
    }
}
