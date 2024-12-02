package com.uber_persona.backend.util;

public class Va_Persona {
    public static final String NOMBRE_NOT_NULL = "El nombre es obligatorio";
    public static final String NOMBRE_SIZE = "El nombre debe tener entre {min} y {max} caracteres";
    public static final String NOMBRE_PATTERN = "El nombre solo debe contener letras, acentos y espacios";
    public static final String APELLIDO_NOT_NULL = "El apellido es obligatorio";
    public static final String APELLIDO_SIZE = "El apellido debe tener entre {min} y {max} caracteres";
    public static final String APELLIDO_PATTERN = "El apellido solo debe contener letras, acentos y espacios";
    public static final String CEDULA_NOT_NULL = "La cédula es obligatoria";
    public static final String CEDULA_SIZE = "La cédula debe tener entre 9 y 10 dígitos numéricos";
    public static final String APELLIDO_REGEXP = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$";
    public static final String NOMBRE_REGEXP = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$";
    public static final String NOMBRE = "NOMBRE";
    public static final String APELLIDO = "APELLIDO";
    public static final String CEDULA = "CEDULA";
    public static final String CEDULA_YA_EXISTE = "La cédula ya existe en el sistema";

}
