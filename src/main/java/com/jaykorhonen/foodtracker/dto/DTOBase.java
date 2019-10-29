package com.jaykorhonen.foodtracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@Data
public abstract class DTOBase {

    private String id;
}
