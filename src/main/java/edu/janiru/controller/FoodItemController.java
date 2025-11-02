package edu.janiru.controller;

import edu.janiru.model.dto.FoodItem;
import edu.janiru.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/food-item")
public class FoodItemController {

    @Autowired
    private FoodItemService service;

    //Basic CRUD
    @PostMapping("/add")
    public String addNewFoodItem(@RequestBody FoodItem foodItem){
        return "Food Item";
    }

    @GetMapping("/get")
    public FoodItem getFoodItem(@PathVariable String itemID){
        return new FoodItem();
    }

    @PutMapping("/update")
    public String updateFoodItem(@RequestBody FoodItem foodItem){
        return "Update";
    }

    @DeleteMapping("/delete")
    public String deleteFoodItem(@PathVariable String itemID){
        return "Item "+itemID+"Deleted";
    }

    //Get Lists Food Items
    @GetMapping("/get-all")
    public List<FoodItem> getAllFoodItem(){
        return new ArrayList<>();
    }

    @GetMapping("/get-all-available")
    public List<FoodItem> getAllAvailableFoodItem(){
        return new ArrayList<>();
    }
}
