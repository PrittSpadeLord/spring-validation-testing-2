package io.github.prittspadelord.validators;

import io.github.prittspadelord.annotations.ValidLocalSpeciality;
import io.github.prittspadelord.models.LocalSpeciality;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class LocalSpecialityConstraintValidator implements ConstraintValidator<ValidLocalSpeciality, LocalSpeciality> {

    @Override
    public boolean isValid(LocalSpeciality localSpeciality, @Autowired ConstraintValidatorContext constraintValidatorContext) {
        if(!Pattern.compile("[a-zA-Z ]+").matcher(localSpeciality.getName()).matches()) return false;
        if(!Pattern.compile("mondstadt|liyue|inazuma|sumeru|fontaine|natlan|nod_krai|snezhnaya").matcher(localSpeciality.getNation()).matches()) return false;
        return true;
    }
}
