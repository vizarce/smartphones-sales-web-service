package com.vitaliy.zhakun.smartphones.repository;

import com.vitaliy.zhakun.smartphones.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
