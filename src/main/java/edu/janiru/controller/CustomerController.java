package edu.janiru.controller;

import edu.janiru.model.dto.Customer;
import edu.janiru.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Basic CRUD
    @PostMapping("/add")
    public String addNewCustomer(@RequestBody Customer customer){
        return "Customer"+customer;
    }

    @GetMapping("/get")
    public Customer getCustomer(@PathVariable String customerID){
        return new Customer();
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
