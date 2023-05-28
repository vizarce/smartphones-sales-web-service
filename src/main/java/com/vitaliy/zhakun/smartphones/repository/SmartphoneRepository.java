package com.vitaliy.zhakun.smartphones.repository;

import com.vitaliy.zhakun.smartphones.model.Smartphone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends MongoRepository<Smartphone, Long> {
    List<Smartphone> getAllByBrandContainingIgnoreCase(String brand);

    List<Smartphone> getAllByModelContainingIgnoreCase(String model);

    List<Smartphone> getAllByProcessorGHzGreaterThanEqual(int processor);

    List<Smartphone> getAllByDisplaySizeInchGreaterThanEqual(double display);

    List<Smartphone> getAllByOriginalPriceUsdIsLessThanEqual(double price);

    List<Smartphone> getAllByRomGb(int rom);

    List<Smartphone> getAllByRamGb(int ram);

    List<Smartphone> getAllByBatteryMahGreaterThanEqual(int battery);

    List<Smartphone> getAllByRearCameraMpGreaterThanEqual(int rearcamera);

    List<Smartphone> getAllByColorsContainingIgnoreCase(String color);

    List<Smartphone> getAllByRatingGreaterThanEqual(double rating);
}
