package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.dto.NamedDTO;
import com.jaykorhonen.foodtracker.exceptions.IngredientAlreadyExistsException;
import com.jaykorhonen.foodtracker.exceptions.IngredientNotFoundException;
import com.jaykorhonen.foodtracker.model.Ingredient;
import com.jaykorhonen.foodtracker.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributeIdentifierException;
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
    public IngredientDTO create(IngredientDTO ingredient) throws IngredientAlreadyExistsException, InvalidAttributeIdentifierException {

        Ingredient existingIngredient;

        if(ingredient.getId() != null) {
            throw new InvalidAttributeIdentifierException("Illegal attribute: id");
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
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);

        if(ingredient != null) {
            ingredientRepository.deleteById(id);
        }

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

        return convertToDTO(ingredient);
    }

    /*
    * Update existing ingredient, return ingredient with new attributes
    * throws if ingredient does not exist */
    public IngredientDTO update(IngredientDTO ingredient) throws IngredientNotFoundException {

        Ingredient persistedIngredient;

        Long id = ingredient.getId();
        if(id != null) {

            if(ingredientRepository.findById(id).orElse(null) == null) {
                throw new IngredientNotFoundException(id);
            }

            persistedIngredient  = Ingredient.builder()
                    .id(ingredient.getId())
                    .name(ingredient.getName())
                    .fat(ingredient.getFat())
                    .carbs(ingredient.getCarbs())
                    .protein(ingredient.getProtein())
                    .servingSize(ingredient.getServingSize())
                    .build();

            persistedIngredient = ingredientRepository.save(persistedIngredient);
        } else {
            Ingredient ingredientWithId = ingredientRepository.findByName(ingredient.getName());

            if(ingredientWithId == null) {
                throw new IngredientNotFoundException(ingredient.getName());
            }

            persistedIngredient  = Ingredient.builder()
                    .id(ingredientWithId.getId())
                    .name(ingredient.getName())
                    .fat(ingredient.getFat())
                    .carbs(ingredient.getCarbs())
                    .protein(ingredient.getProtein())
                    .servingSize(ingredient.getServingSize())
                    .build();

            persistedIngredient = ingredientRepository.save(persistedIngredient);
        }
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
        IngredientDTO dto = findByName(name);
        dto = delete(dto.getId());

        return dto;
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
