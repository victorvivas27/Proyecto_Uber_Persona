package com.uber_persona.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExactDigitsValidator implements ConstraintValidator<ExactDigits, Long> {

    private int exactDigits;

    @Override
    public void initialize(ExactDigits constraintAnnotation) {
        this.exactDigits = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return true;

        return String.valueOf(value).length() == exactDigits;
    }
}
