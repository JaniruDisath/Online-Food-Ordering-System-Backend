package edu.janiru.repository;

import edu.janiru.model.dto.Customer;
import edu.janiru.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {
}
