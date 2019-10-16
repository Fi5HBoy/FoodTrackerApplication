package com.jaykorhonen.foodtracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class EntityBase {

    @Id
    Long id;
}
