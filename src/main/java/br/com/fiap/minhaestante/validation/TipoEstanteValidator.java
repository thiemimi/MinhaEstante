package br.com.fiap.minhaestante.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoEstanteValidator implements ConstraintValidator<TipoEstante, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("LENDO") || value.equals("LIDO");
    }



}
