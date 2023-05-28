package com.vitaliy.zhakun.smartphones.repository;

import com.vitaliy.zhakun.smartphones.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

    //@Query(fields = "{'id': 1}")
    //List<Long> findAllIds();
}
