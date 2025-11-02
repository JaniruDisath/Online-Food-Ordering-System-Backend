package edu.janiru.repository;

import edu.janiru.model.dto.FoodItem;
import edu.janiru.model.entity.FoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItemEntity,String> {
}
