package com.jaykorhonen.foodtracker.model.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.List;

public class FoodService {

    @Autowired
    private FoodRepository foodRepository;


}
