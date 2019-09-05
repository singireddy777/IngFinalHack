package com.hcl.rubikbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rubikbank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	 Optional<Customer> findByCustomerId(Integer customerId);
}
