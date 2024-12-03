package com.uber_persona.backend.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExactDigitsValidator.class)
public @interface ExactDigits {
    String message() default "{validation.persona.cedula.size}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();
}