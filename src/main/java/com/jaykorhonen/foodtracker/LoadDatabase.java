package com.jaykorhonen.foodtracker;

import com.jaykorhonen.foodtracker.model.food.Food;
import com.jaykorhonen.foodtracker.model.food.FoodRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(FoodRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Food("Chicken", 0, 40, 30, 300)));
            log.info("Preloading " + repository.save(new Food("Cheese", 9, 0, 7, 300)));
        };
    }
}
