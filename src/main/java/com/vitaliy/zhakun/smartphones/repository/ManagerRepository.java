package com.vitaliy.zhakun.smartphones.repository;

import com.vitaliy.zhakun.smartphones.model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, Long> {

    List<Manager> findByExperience(int experience);

    List<Manager> findBySales(int sales);

    List<Manager> findByGender(String gender);
}
