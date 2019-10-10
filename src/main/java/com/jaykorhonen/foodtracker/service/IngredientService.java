package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.model.Ingredient;
import com.jaykorhonen.foodtracker.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class IngredientService implements IngredientServiceBase {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO create(IngredientDTO ingredient) {
        Ingredient persistedIngredient = Ingredient.builder()
                .name(ingredient.getName())
                .fat(ingredient.getFat())
                .carbs(ingredient.getCarbs())
                .protein(ingredient.getProtein())
                .servingSize(ingredient.getServingSize())
                .build();
        persistedIngredient = ingredientRepository.save(persistedIngredient);
        if(persistedIngredient != null) {
            return convertToDTO(persistedIngredient);
        } else {
            return new IngredientDTO();
        }
    }

    @Override
    public IngredientDTO delete(String id) {
        return null;
    }

    @Override
    public List<IngredientDTO> findAll() {
        List<Ingredient> todoEntries = ingredientRepository.findAll();
        return convertToDTOs(todoEntries);
    }

    @Override
    public IngredientDTO findById(String id) {
        return null;
    }

    @Override
    public IngredientDTO update(IngredientDTO todo) {
        return null;
    }

    private IngredientDTO convertToDTO(Ingredient model) {
        IngredientDTO dto = new IngredientDTO();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setFat(model.getFat());
        dto.setCarbs(model.getCarbs());
        dto.setProtein(model.getProtein());
        dto.setServingSize(model.getServingSize());
        dto.setCalories(model.getCalories());

        return dto;
    }

    private List<IngredientDTO> convertToDTOs(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
}
