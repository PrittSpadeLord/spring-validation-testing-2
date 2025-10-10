package io.github.prittspadelord.models;

import io.github.prittspadelord.annotations.ValidLocalSpeciality;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
    @NotEmpty String name;
    @ValidLocalSpeciality LocalSpeciality localSpeciality;
}
