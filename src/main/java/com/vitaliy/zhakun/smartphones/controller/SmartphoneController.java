package com.vitaliy.zhakun.smartphones.controller;

import com.vitaliy.zhakun.smartphones.model.Smartphone;
import com.vitaliy.zhakun.smartphones.repository.SmartphoneRepository;
import com.vitaliy.zhakun.smartphones.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService, SmartphoneRepository smartphoneRepository) {
        this.smartphoneService = smartphoneService;
        this.smartphoneRepository = smartphoneRepository;
    }

    @GetMapping("/all")
    public List<Smartphone> getAllSmartphones() {
        return smartphoneService.getAllSmartphones();
    }

    @GetMapping("/all/sorted")
    public List<Smartphone> getAllSmartphonesSorted(@RequestParam(value = "order", defaultValue = "id") String order) {
        return smartphoneService.getAllSmartphonesSorted(order);
    }

    @GetMapping("/{id}")
    public Smartphone getSmartphoneById(@PathVariable("id") Long id) {
        return smartphoneService.getSmartphoneById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Smartphone> addSmartphone(@RequestBody Smartphone smartPhone) {
        Smartphone createdSmartphone = smartphoneService.createSmartphone(smartPhone);
        return new ResponseEntity<Smartphone>(createdSmartphone, HttpStatus.CREATED);
    }

    @PostMapping("/add/all")
    public ResponseEntity<List<Smartphone>> addSmartphones(@RequestBody Iterable<Smartphone> smartPhones) {
        List<Smartphone> createdSmartphones = smartphoneService.createSmartphones(smartPhones);
        return new ResponseEntity<List<Smartphone>>(createdSmartphones, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public Smartphone updateSmartphone(@RequestBody Smartphone smartPhone, @PathVariable("id") Long id) {
        return smartphoneService.updateSmartphone(smartPhone, id);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Smartphone> deleteSmartphoneById(@PathVariable("id") Long id) {
        Smartphone deletedSmartphone = smartphoneService.getSmartphoneById(id);
        smartphoneService.deleteSmartphoneById(id);
        return new ResponseEntity<Smartphone>(deletedSmartphone, HttpStatus.OK);
    }

    @GetMapping("/get/brand")
    public List<Smartphone> getSmartphonesByBrand(@RequestParam(value = "brand", defaultValue = "Samsung") String brand) {
        return smartphoneRepository.getAllByBrandContainingIgnoreCase(brand);
    }

    @GetMapping("/get/model")
    public List<Smartphone> getSmartphonesByModel(@RequestParam(value = "model", defaultValue = "Galaxy") String model) {
        return smartphoneRepository.getAllByModelContainingIgnoreCase(model);
    }

    @GetMapping("/get/processor")
    public List<Smartphone> getAllByProcessorGHz(@RequestParam(value = "processor", defaultValue = "2500") int processor) {
        List<Smartphone> found = smartphoneRepository.getAllByProcessorGHzGreaterThanEqual(processor);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with frequency equal " + processor + " GHz or greater were not fond.");
        return found;
    }

    @GetMapping("/get/display")
    public List<Smartphone> getAllByDisplaySizeInch(@RequestParam(value = "display", defaultValue = "6.1") double display) {
        List<Smartphone> found = smartphoneRepository.getAllByDisplaySizeInchGreaterThanEqual(display);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with displaySize equal " + display + " Inches or greater were not fond.");
        return found;
    }

    @GetMapping("/get/price")
    public List<Smartphone> getAllByOriginalPriceUsd(@RequestParam(value = "price", defaultValue = "999.99") double price) {
        List<Smartphone> found = smartphoneRepository.getAllByOriginalPriceUsdIsLessThanEqual(price);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with price equal " + price + " dollars or less were not fond.");
        return found;
    }

    @GetMapping("/get/rom")
    public List<Smartphone> getAllByRomGb(@RequestParam(value = "rom", defaultValue = "8") int rom) {
        List<Smartphone> found = smartphoneRepository.getAllByRomGb(rom);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with ROM Size equal " + rom + " Gb were not fond.");
        return found;
    }

    @GetMapping("/get/ram")
    public List<Smartphone> getAllByRamGb(@RequestParam(value = "ram", defaultValue = "8") int ram) {
        List<Smartphone> found = smartphoneRepository.getAllByRamGb(ram);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with RAM Size equal " + ram + " Gb were not fond.");
        return found;
    }

    @GetMapping("/get/battery")
    public List<Smartphone> getAllByBatteryMah(@RequestParam(value = "battery", defaultValue = "4500") int battery) {
        List<Smartphone> found = smartphoneRepository.getAllByBatteryMahGreaterThanEqual(battery);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with Battery Capacity equal " + battery + " Mah or greater were not fond.");
        return found;
    }

    @GetMapping("/get/rearcamera")
    public List<Smartphone> getAllByRearCameraMp(@RequestParam(value = "rearcamera", defaultValue = "35") int rearcamera) {
        List<Smartphone> found = smartphoneRepository.getAllByRearCameraMpGreaterThanEqual(rearcamera);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with Rear Camera Resolution equal " + rearcamera + " Mp or greater were not fond.");
        return found;
    }

    @GetMapping("/get/color")
    public List<Smartphone> getAllByColor(@RequestParam(value = "color", defaultValue = "dark") String color) {
        List<Smartphone> found = smartphoneRepository.getAllByColorsContainingIgnoreCase(color);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with color " + color + " were not fond.");
        return found;
    }

    @GetMapping("/get/rating")
    public List<Smartphone> getAllByRating(@RequestParam(value = "rating", defaultValue = "3.9") double rating) {
        List<Smartphone> found = smartphoneRepository.getAllByRatingGreaterThanEqual(rating);
        if (found.isEmpty())
            throw new IllegalStateException("Smartphones with Rating equal " + rating + " or greater were not fond.");
        return found;
    }
}
