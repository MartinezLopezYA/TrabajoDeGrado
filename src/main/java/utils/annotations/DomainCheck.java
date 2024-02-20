package utils.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import utils.validators.DomainCheckValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DomainCheckValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainCheck {
    String message() default "El correo electrónico debe pertenecer al dominio uniminuto.edu.co";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
