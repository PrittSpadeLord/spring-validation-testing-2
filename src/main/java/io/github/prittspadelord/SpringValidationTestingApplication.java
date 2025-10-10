package io.github.prittspadelord;

import io.github.prittspadelord.config.SpringAppConfig;
import io.github.prittspadelord.models.Character;
import io.github.prittspadelord.models.LocalSpeciality;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class SpringValidationTestingApplication {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Validator validator = context.getBean(Validator.class);

        LocalSpeciality localSpeciality = new LocalSpeciality();

        localSpeciality.setName("Dendrobium");
        localSpeciality.setNation("inazuma");

        Character character = new Character();
        character.setName("Chiori");
        character.setLocalSpeciality(localSpeciality);

        Set<ConstraintViolation<Character>> violations = validator.validate(character);

        if(violations.isEmpty()) {
            System.out.println("No violations!");
        }
        else for(ConstraintViolation<Character> violation: violations) {
            System.out.println(violation.getPropertyPath().toString() + " " + violation.getMessage());
        }
    }
}