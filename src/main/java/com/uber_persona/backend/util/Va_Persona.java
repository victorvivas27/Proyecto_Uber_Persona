package com.uber_persona.backend.util;

public class Va_Persona {
    public static final String NOMBRE_NOT_NULL = "El nombre es obligatorio";
    public static final String NOMBRE_PATTERN = "El nombre solo debe contener letras, acentos y espacios";
    public static final String NOMBRE_REGEXP = "^(?!\\s*$)[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]{2,50}$";
    public static final String NOMBRE_VALIDO = "Jose Jose";
    public static final String NOMBRE = "NOMBRE";


    public static final String APELLIDO_NOT_NULL = "El apellido es obligatorio";
    public static final String APELLIDO_PATTERN = "El apellido solo debe contener letras, acentos y espacios";
    public static final String APELLIDO_REGEXP = "^(?!\\s*$)[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]{2,50}$";
    public static final String APELLIDO = "APELLIDO";
    public static final String APELLIDO_VALIDO = "Vivas";


    public static final String CEDULA_NOT_NULL = "La cédula es obligatoria";
    public static final String CEDULA = "CEDULA";
    public static final String CEDULA_YA_EXISTE = "La cédula ya existe en el sistema";
    public static final String CEDULA_VALIDA = "27076517";
    public static final String CEDULA_PATTERN = "La cédula solo debe contener números";
    public static final String CEDULA_SIZE = "La cédula debe tener exactamente 8 dígitos numéricos";

}
