package io.github.prittspadelord.annotations;

import io.github.prittspadelord.validators.LocalSpecialityConstraintValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocalSpecialityConstraintValidator.class)
public @interface ValidLocalSpeciality {
    String message() default "Invalid local speciality format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}