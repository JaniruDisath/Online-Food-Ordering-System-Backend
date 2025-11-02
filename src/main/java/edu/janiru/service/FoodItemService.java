package edu.janiru.service;

import edu.janiru.model.dto.FoodItem;
import edu.janiru.model.entity.FoodItemEntity;
import edu.janiru.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    //Basic CRUD
    //ADD
    public void addFoodItem(FoodItem foodItem) {
        foodItemRepository.save(
                new FoodItemEntity(
                        foodItem.getId(),
                        foodItem.getName(),
                        foodItem.getPrice(),
                        foodItem.getDescription(),
                        foodItem.getStock(),
                        foodItem.getPortion()
                )
        );
    }

    //Get
    public FoodItem getFoodItem(String foodItemId) {
        Optional<FoodItemEntity> byId = foodItemRepository.findById(foodItemId);
        FoodItemEntity foodItemEntity = byId.get();

        return new FoodItem(
                foodItemEntity.getId(),
                foodItemEntity.getName(),
                foodItemEntity.getPrice(),
                foodItemEntity.getDescription(),
                foodItemEntity.getStock(),
                foodItemEntity.getPortion()
        );

    }

    //Update
    public String updateFoodItem(FoodItem foodItem) {
        FoodItem foodItemDB = getFoodItem((foodItem.getId()));
        if (foodItemDB == null) {
            return "Item does not exist";
        } else {
            if (!Objects.equals(foodItemDB.getName(), foodItem.getName())) foodItemDB.setName(foodItem.getName());
            if (!Objects.equals(foodItemDB.getPrice(), foodItem.getPrice())) foodItemDB.setPrice(foodItem.getPrice());
            if (!Objects.equals(foodItemDB.getDescription(), foodItem.getDescription()))
                foodItemDB.setDescription(foodItem.getDescription());
            if (foodItemDB.getStock() != foodItem.getStock()) foodItemDB.setStock(foodItem.getStock());
            if (foodItemDB.getPortion() != foodItem.getPortion()) foodItemDB.setPortion(foodItem.getPortion());
        }
        return "Successful";
    }

    //Delete
    public String deleteFoodItem(String foodItemID){
        FoodItem foodItemDB = getFoodItem(foodItemID);
        if (foodItemDB == null) {
            return "Item does not exist";
        } else {
            foodItemRepository.deleteById(foodItemID);
        }
        return "Successful";
    }


    //Get Food Items Lists
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItemList = new ArrayList<>();
        for (FoodItemEntity foodItemEntity : foodItemRepository.findAll()) {
            foodItemList.add(
                    new FoodItem(
                            foodItemEntity.getId(),
                            foodItemEntity.getName(),
                            foodItemEntity.getPrice(),
                            foodItemEntity.getDescription(),
                            foodItemEntity.getStock(),
                            foodItemEntity.getPortion()
                    )
            );
        }
        return foodItemList;
    }

    public List<FoodItem> getAllAvailableFoodItems() {
        List<FoodItem> availableFoodItemList = new ArrayList<>();
        for (FoodItem foodItem : getAllFoodItems()) {
            if (foodItem.getStock() != 0 | foodItem.getStock() > 0) {
                availableFoodItemList.add(foodItem);
            }
        }
        return availableFoodItemList;
    }
}
