package com.jaykorhonen.foodtracker.model.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MealController {

    private final Logger log = LoggerFactory.getLogger(MealController.class);
    private MealRepositoryImpl mealRepositoryImpl;

    public MealController(MealRepositoryImpl mealRepositoryImpl) {
        this.mealRepositoryImpl = mealRepositoryImpl;
    }

    @GetMapping("/meals")
    List<Meal> meals() {
        return mealRepositoryImpl.findAll();
    }

    @GetMapping("/meal/{id}")
    ResponseEntity<?> getMeal(@PathVariable Long id) {
        Optional<Meal> meal = mealRepositoryImpl.findById(id);
        return meal.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/meal")
    ResponseEntity<Meal> createMeal(@Valid @RequestBody Meal meal) throws URISyntaxException {
        log.info("Request to create meal: {}", meal);
        Meal result = mealRepositoryImpl.save(meal);
        return ResponseEntity.created(new URI("/api/meal/" + result.getId()))
                .body(result);
    }

    @PutMapping("/meal/{id}")
    ResponseEntity<Meal> updateMeal(@Valid @RequestBody Meal meal) {
        log.info("Request to update meal: {}", meal);
        Meal result = mealRepositoryImpl.save(meal);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/meal/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable Long id) {
        log.info("Request to delete meal: {}", id);
        mealRepositoryImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
