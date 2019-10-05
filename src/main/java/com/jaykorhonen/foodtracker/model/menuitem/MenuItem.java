package com.jaykorhonen.foodtracker.model.menuitem;

import com.jaykorhonen.foodtracker.model.serving.Serving;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class MenuItem {

    @Id
    private String id;

    @NonNull
    private String name;
    private double totalCalories;

    @DBRef
    private List<Serving> servings;

    MenuItem(String name, List<Serving> servings, double totalCalories) {
        this.name = name;
        this.servings = servings;
        this.totalCalories = totalCalories;
    }
}
