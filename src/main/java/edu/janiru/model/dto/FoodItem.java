package edu.janiru.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodItem {
    private String id;
    private String name;
    private Double price;
    private String description;
    private int portion;
}
