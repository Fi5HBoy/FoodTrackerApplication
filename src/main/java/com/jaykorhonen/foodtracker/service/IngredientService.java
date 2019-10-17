package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.exceptions.IngredientAlreadyExistsException;
import com.jaykorhonen.foodtracker.exceptions.IngredientNotFoundException;
import com.jaykorhonen.foodtracker.exceptions.InvalidArgumentException;
import com.jaykorhonen.foodtracker.model.Ingredient;
import com.jaykorhonen.foodtracker.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class IngredientService implements NamedEntityService<IngredientDTO> {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /*
    * Create ingredient, returns the saved ingredient
    * throws if ingredient already exists
    * */
    public IngredientDTO create(IngredientDTO ingredient) throws RuntimeException {

        Ingredient existingIngredient;

        if(ingredient.getId() != null) {
            throw new InvalidArgumentException("id");
        }

        existingIngredient = ingredientRepository.findByName(ingredient.getName());
        if(existingIngredient != null) {
            throw new IngredientAlreadyExistsException(existingIngredient);
        }

        Ingredient persistedIngredient = Ingredient.builder()
                .name(ingredient.getName())
                .fat(ingredient.getFat())
                .carbs(ingredient.getCarbs())
                .protein(ingredient.getProtein())
                .servingSize(ingredient.getServingSize())
                .build();
        persistedIngredient = ingredientRepository.save(persistedIngredient);

        return convertToDTO(persistedIngredient);
    }

    /*
    * Delete ingredient if it exists, return ingredient deleted
    * */
    public IngredientDTO delete(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(new Ingredient());

        ingredientRepository.deleteById(id);

        return convertToDTO(ingredient);
    }

    /*
    * Return a list of all ingredients
    * */
    public List<IngredientDTO> findAll() {
        List<Ingredient> ingredientEntries = ingredientRepository.findAll();

        return convertToDTOs(ingredientEntries);
    }

    /*
    * Return ingredient with given id
    * */
    public IngredientDTO findById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);

        if(ingredient == null) {
            throw new IngredientNotFoundException(id);
        }

        return convertToDTO(ingredient);
    }

    /*
    * Update existing ingredient, return ingredient with new attributes
    * throws if ingredient does not exist */
    public IngredientDTO update(IngredientDTO ingredient) throws IngredientNotFoundException {

        Ingredient persistedIngredient;
        Long id;
        boolean hasId = ingredient.getId() != null;
        boolean foundId = ingredientRepository.findIdByName(ingredient.getName()) != null;

        if (hasId) {
            id = ingredient.getId();
        } else if (foundId) {
            id = ingredientRepository.findIdByName(ingredient.getName());
        } else {
            throw new IngredientNotFoundException(ingredient.getName());
        }

        if (!ingredientRepository.findById(id).isPresent()) {
            throw new IngredientNotFoundException(id);
        }

        persistedIngredient  = Ingredient.builder()
                .id(id)
                .name(ingredient.getName())
                .fat(ingredient.getFat())
                .carbs(ingredient.getCarbs())
                .protein(ingredient.getProtein())
                .servingSize(ingredient.getServingSize())
                .build();

        persistedIngredient = ingredientRepository.save(persistedIngredient);

        return convertToDTO(persistedIngredient);
    }

    /*
    * Return ingredient with given name
    * */
    public IngredientDTO findByName(String name) throws IngredientNotFoundException {
        Ingredient ingredient = ingredientRepository.findByName(name);

        if(ingredient == null) {
            throw new IngredientNotFoundException(name);
        }

        return convertToDTO(ingredient);
    }

    /*
    * Delete ingredient with given name, return deleted ingredient
    * */
    public IngredientDTO deleteByName(String name) {
        Ingredient ingredient = ingredientRepository.findByName(name);

        ingredientRepository.deleteByName(name);

        return convertToDTO(ingredient);
    }

    private IngredientDTO convertToDTO(Ingredient model) {
        IngredientDTO dto = new IngredientDTO();

        if(model != null) {
            dto.setId(model.getId());
            dto.setName(model.getName());
            dto.setFat(model.getFat());
            dto.setCarbs(model.getCarbs());
            dto.setProtein(model.getProtein());
            dto.setServingSize(model.getServingSize());
            dto.setCalories(model.getCalories());
        }

        return dto;
    }

    private List<IngredientDTO> convertToDTOs(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
}
