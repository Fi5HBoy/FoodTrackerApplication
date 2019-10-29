package com.jaykorhonen.foodtracker.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public abstract class NamedDTO extends DTOBase {

    @NotNull
    private String name;
}
