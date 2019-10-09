package com.jaykorhonen.foodtracker.model.ingredient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final Logger log = LoggerFactory.getLogger(IngredientController.class);
    private IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @CrossOrigin(origins = 'http://localhost:3000')
    @GetMapping
    List<IngredientBase> ingredients() {
        return ingredientRepository.findAll();
    }
}
