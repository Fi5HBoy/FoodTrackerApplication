package com.jaykorhonen.foodtracker.model.meal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findByName(String name);
}
