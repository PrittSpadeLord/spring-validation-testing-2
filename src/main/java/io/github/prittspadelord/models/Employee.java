package io.github.prittspadelord.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    @NotEmpty
    private String name;
    
    @Email
    private String email;
}
