package io.github.prittspadelord.config;

import jakarta.validation.Validator;

import org.apache.bval.jsr.ApacheValidationProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = "io.github.prittspadelord.validators")
public class SpringAppConfig {

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setProviderClass(ApacheValidationProvider.class);
        return factoryBean;
    }

    @Bean
    @Primary
    public Validator validator(@Autowired LocalValidatorFactoryBean validatorFactoryBean) {
        return validatorFactoryBean.getValidator();
    }
}