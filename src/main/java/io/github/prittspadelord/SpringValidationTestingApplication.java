package io.github.prittspadelord;

import io.github.prittspadelord.config.SpringAppConfig;
import jakarta.validation.Validator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringValidationTestingApplication {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Validator validator = context.getBean("validator", Validator.class);

        //.
    }
}
