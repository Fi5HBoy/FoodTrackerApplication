package com.jaykorhonen.foodtracker.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class IngredientDTO extends NamedDTO {

    @NotNull
    private double fat;
    @NotNull
    private double carbs;
    @NotNull
    private double protein;
    @NotNull
    private double servingSize;

    private double calories;
}
