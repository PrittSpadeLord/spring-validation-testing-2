package io.github.prittspadelord;

import io.github.prittspadelord.config.SpringAppConfig;
import io.github.prittspadelord.models.Employee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class SpringValidationTestingApplication {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Validator validator = context.getBean(Validator.class);

        Employee pritt = new Employee();

        pritt.setName("");
        pritt.setEmail("pritt1999");

        Set<ConstraintViolation<Employee>> violations = validator.validate(pritt);

        if(violations.isEmpty()) {
            System.out.println("No violations!");
        }
        else for(ConstraintViolation<Employee> violation: violations) {
            System.out.println(violation.getPropertyPath().toString() + " " + violation.getMessage());
        }
    }
}
