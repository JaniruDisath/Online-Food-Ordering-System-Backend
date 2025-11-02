package edu.janiru.controller;

import edu.janiru.model.dto.FoodItem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food_item")
public class FoodItemController {

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

    //Get All Food Items
}
