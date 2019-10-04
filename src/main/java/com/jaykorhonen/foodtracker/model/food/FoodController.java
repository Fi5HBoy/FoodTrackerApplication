package com.jaykorhonen.foodtracker.model.food;

import com.jaykorhonen.foodtracker.model.food.exceptions.FoodAlreadyExistsException;

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
@RequestMapping("/api/food")
public class FoodController {

    private final Logger log = LoggerFactory.getLogger(FoodController.class);
    private FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    List<Food> foods() {
        return foodRepository.findAll();
    }

    @GetMapping(value = "/food/{id}")
    ResponseEntity<?> getFood(@PathVariable String id) {
        Optional<Food> food = foodRepository.findById(id);
        return food.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/food")
    ResponseEntity<Food> createFood(@Valid @RequestBody Food food) throws URISyntaxException, FoodAlreadyExistsException {
        log.info("Request to create food: {}", food);
        if(foodRepository.existsByName(food.getName())){
            throw new FoodAlreadyExistsException(food);
        }

        Food result = foodRepository.save(food);
        return ResponseEntity.created(new URI("/api/food/" + result.getId()))
                .body(result);
    }

    @PutMapping("/food/{id}")
    ResponseEntity<Food> updateFood(@Valid @RequestBody Food food) {
        log.info("Request to update food: {}", food);
        Food result = foodRepository.save(food);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/food/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable String id) {
        log.info("Request to delete food: {}", id);
        foodRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
