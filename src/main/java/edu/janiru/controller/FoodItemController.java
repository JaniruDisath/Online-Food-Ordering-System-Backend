package edu.janiru.controller;

import edu.janiru.model.dto.FoodItem;
import edu.janiru.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("food-item")
public class FoodItemController {

    @Autowired
    private FoodItemService service;

    //Basic CRUD
    @PostMapping("/add")
    public String addNewFoodItem(@RequestBody FoodItem foodItem){
        service.addFoodItem(foodItem);
        return "Food Item";
    }

    @GetMapping("/get/{itemID}")
    public FoodItem getFoodItem(@PathVariable String itemID){
        System.out.println(service.getFoodItem(itemID));
        return service.getFoodItem(itemID);
    }

    @PutMapping("/update")
    public String updateFoodItem(@RequestBody FoodItem foodItem){
        return service.updateFoodItem(foodItem);
    }

    @DeleteMapping("/delete/{itemID}")
    public String deleteFoodItem(@PathVariable String itemID){
        return service.deleteFoodItem(itemID);
    }

    //Get Lists Food Items
    @GetMapping("/get-all")
    public List<FoodItem> getAllFoodItem(){
        return service.getAllFoodItems();
    }

    @GetMapping("/get-all-available")
    public List<FoodItem> getAllAvailableFoodItem(){
        return service.getAllAvailableFoodItems();
    }
}
