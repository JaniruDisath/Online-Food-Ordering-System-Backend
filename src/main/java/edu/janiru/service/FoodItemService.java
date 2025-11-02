package edu.janiru.service;

import edu.janiru.model.dto.FoodItem;
import edu.janiru.model.entity.FoodItemEntity;
import edu.janiru.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems(){
        List<FoodItem> bookList = new ArrayList<>();
        for (FoodItemEntity foodItemEntity : foodItemRepository.findAll()) {
            bookList.add(
                    new FoodItem(
                            foodItemEntity.getId(),
                            foodItemEntity.getName(),
                            foodItemEntity.getPrice(),
                            foodItemEntity.getDescription(),
                            foodItemEntity.getPortion()
                    )
            );
        }
        return bookList;
    }
}
