package utils.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import utils.annotations.DomainCheck;

public class DomainCheckValidator implements ConstraintValidator<DomainCheck, String> {
    @Override
    public void initialize(DomainCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.endsWith("@uniminuto.edu.co") || value.endsWith("@uniminuto.edu"));
    }
}
