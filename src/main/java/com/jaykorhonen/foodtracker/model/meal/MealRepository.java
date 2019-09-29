package com.jaykorhonen.foodtracker.model.meal;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<Meal, String> {
}
