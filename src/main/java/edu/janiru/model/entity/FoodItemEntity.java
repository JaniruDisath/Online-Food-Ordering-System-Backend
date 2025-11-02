package edu.janiru.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="food_item")
public class FoodItemEntity {
    @Id
    private String id;
    private String name;
    private Double price;
    private String description;
    private int stock;
    private int portion;
}
