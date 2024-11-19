package com.uber_persona.backend;

import com.uber_persona.backend.util.Va_Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.uber_persona.backend"})
public class UberPersonaApplication {
    public static void main(String[] args) {
        SpringApplication.run(UberPersonaApplication.class, args);
        Va_Persona.info("¡Uber Persona iniciada correctamente! Accesible en: http://localhost:5050");
    }
}
