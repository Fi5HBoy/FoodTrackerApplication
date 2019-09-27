package com.jaykorhonen.foodtracker.model.meal;

import org.springframework.data.jpa.repository.JpaRepository;

//TODO: this is wrong
public interface MealRepositoryImpl extends JpaRepository<Meal, Long> {
    Meal findByName(String name);
}
