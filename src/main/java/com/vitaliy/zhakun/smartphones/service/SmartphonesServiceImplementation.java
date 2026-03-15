package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Smartphone;
import com.vitaliy.zhakun.smartphones.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SmartphonesServiceImplementation implements SmartphoneService {

    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of(
            "id", "brand", "model", "subModel", "chipset", "processorGHz",
            "romGb", "ramGb", "batteryMah", "rearCameraMp", "frontCameraMp",
            "displaySizeInch", "weightOunces", "length", "height", "width",
            "originalPriceUsd", "goldMembersDiscount", "silverMembersDiscount",
            "rating", "quantity"
    );

    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphonesServiceImplementation(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Override
    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    @Override
    public List<Smartphone> getAllSmartphonesSorted(String order) {
        if (!ALLOWED_SORT_FIELDS.contains(order))
            throw new IllegalStateException("Invalid sort field: " + order);
        Sort sort = Sort.by(order);
        return smartphoneRepository.findAll(sort);
    }

    @Override
    public Smartphone getSmartphoneById(Long id) {
        Optional<Smartphone> optionalSmartphone = smartphoneRepository.findById(id);
        if (optionalSmartphone.isEmpty())
            throw new IllegalStateException("Smartphone with Id = " + id + " does not exist.");
        return optionalSmartphone.get();
    }

    @Override
    public Smartphone createSmartphone(Smartphone smartPhone) {
        Optional<Smartphone> optionalSmartphone = smartphoneRepository.findById(smartPhone.getId());
        if (optionalSmartphone.isPresent())
            throw new IllegalStateException("Smartphone with Id = " + smartPhone.getId() + " is already exist in the Database.");
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public List<Smartphone> createSmartphones(Iterable<Smartphone> smartPhones) {
        return smartphoneRepository.saveAll(smartPhones);
    }

    @Override
    public Smartphone updateSmartphone(Smartphone smartPhone, Long id) {
        Optional<Smartphone> optionalSmartphone = smartphoneRepository.findById(id);
        if (optionalSmartphone.isEmpty())
            throw new IllegalStateException("Smartphone with Id = " + id + " does not exist.");
        smartPhone.setId(id);
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public void deleteSmartphoneById(Long id) {
        Optional<Smartphone> optionalSmartphone = smartphoneRepository.findById(id);
        if (optionalSmartphone.isEmpty())
            throw new IllegalStateException("Smartphone with Id = " + id + " does not exist.");
        else
            smartphoneRepository.deleteById(id);
    }
}
