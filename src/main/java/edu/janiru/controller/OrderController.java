package edu.janiru.controller;

import edu.janiru.model.dto.Order;
import edu.janiru.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Basic CRUD
    @PostMapping("/add")
    public String addNewOrder(@RequestBody Order order){
        return "Order";
    }

    @GetMapping("/get")
    public Order getOrder(@PathVariable String orderID){
        return new Order();
    }

    @PutMapping("/update")
    public String updateOrder(@RequestBody Order order){
        return "Update";
    }

    @DeleteMapping("/delete")
    public String deleteOrder(@PathVariable String orderID){
        return "Item "+orderID+"Deleted";
    }
}
