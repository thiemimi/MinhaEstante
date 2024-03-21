package br.com.fiap.minhaestante.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoEstanteValidator.class)
public @interface TipoEstante {

    String message() default "{estante.tipo}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
