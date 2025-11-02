package edu.janiru.controller;

import edu.janiru.model.dto.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //Basic CRUD
    @PostMapping("/add")
    public String addNewCustomer(@RequestBody Customer customer){
        return "Customer"+customer;
    }

    @GetMapping("/get")
    public Customer getCustomer(@PathVariable String customerID){
        return new Customer(10);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer){
        return "Update";
    }

    @DeleteMapping("/delete")
    public String deleteCustomer(@PathVariable String customerID){
        return "Item "+customerID+"Deleted";
    }

}
