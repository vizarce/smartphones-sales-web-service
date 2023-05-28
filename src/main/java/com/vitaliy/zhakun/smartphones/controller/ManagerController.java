package com.vitaliy.zhakun.smartphones.controller;

import com.vitaliy.zhakun.smartphones.model.Manager;
import com.vitaliy.zhakun.smartphones.repository.ManagerRepository;
import com.vitaliy.zhakun.smartphones.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerService managerService;

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerController(ManagerService managerService, ManagerRepository managerRepository) {
        this.managerService = managerService;
        this.managerRepository = managerRepository;
    }


    @GetMapping("/all")
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable("id") Long id) {
        Manager manager = managerService.getManagerById(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        Manager savedManager = managerService.addManager(manager);
        return new ResponseEntity<Manager>(savedManager, HttpStatus.CREATED);
    }

    @PostMapping("/add/all")
    public ResponseEntity<List<Manager>> createManagers(@RequestBody Iterable<Manager> managers) {
        List<Manager> savedManagers = managerService.addManagers(managers);
        return new ResponseEntity<List<Manager>>(savedManagers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public Manager updateManager(@RequestBody Manager manager, @PathVariable("id") Long id) {
        return managerService.updateManager(manager, id);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Manager> deleteManagerById(@PathVariable("id") Long id) {
        Manager deletedManager = managerService.getManagerById(id);
        managerService.deleteManagerById(id);
        return new ResponseEntity<Manager>(deletedManager, HttpStatus.OK);
    }

    @GetMapping("/find/experience")
    public List<Manager> findManagersByExperience(@RequestParam int experience) {
        return managerRepository.findByExperience(experience);
    }

    @GetMapping("/find/sales")
    public List<Manager> findManagersBySales(@RequestParam int sales) {
        return managerRepository.findBySales(sales);
    }

    @GetMapping("/find/gender")
    public List<Manager> findManagersByGender(@RequestParam String gender) {
        return managerRepository.findByGender(gender);
    }
}
