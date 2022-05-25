package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> getCustomerByName(String name);

}
