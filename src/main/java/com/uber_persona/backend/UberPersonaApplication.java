package com.uber_persona.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class UberPersonaApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(UberPersonaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UberPersonaApplication.class, args);
        LOGGER.info("¡Uber Persona iniciada correctamente! Accesible en: http://localhost:5050");
    }
}
