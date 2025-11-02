package edu.janiru.service;

import edu.janiru.model.dto.Customer;
import edu.janiru.model.dto.FoodItem;
import edu.janiru.model.entity.CustomerEntity;
import edu.janiru.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //Basic CRUD
    //ADD
    public void addCustomer(Customer customer) {
        customerRepository.save(
                new CustomerEntity(
                        customer.getId(),
                        customer.getTitle(),
                        customer.getName(),
                        customer.getMobileNumber(),
                        customer.getEmail()
                )
        );
    }

    //Get
    public Customer getCustomer(String foodItemId) {
        Optional<CustomerEntity> byId = customerRepository.findById(foodItemId);
        CustomerEntity foodItemEntity = byId.get();

        return new Customer(
                foodItemEntity.getId(),
                foodItemEntity.getTitle(),
                foodItemEntity.getName(),
                foodItemEntity.getMobileNumber(),
                foodItemEntity.getEmail()

        );

    }

    //Update
    public String updateFoodItem(Customer customer) {
        addCustomer(customer);
        return "Successful";
    }

    //Delete
    public String deleteFoodItem(String customerID){
        Customer foodItemDB = getCustomer(customerID);
        if (foodItemDB == null) {
            return "Item does not exist";
        } else {
            customerRepository.deleteById(customerID);
        }
        return "Successful";
    }


    //Get Food Items Lists
    public List<Customer> getAllFoodItems() {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            customerList.add(
                    new Customer(
                            customerEntity.getId(),
                            customerEntity.getTitle(),
                            customerEntity.getName(),
                            customerEntity.getMobileNumber(),
                            customerEntity.getEmail()
                    )
            );
        }
        return customerList;
    }
}
