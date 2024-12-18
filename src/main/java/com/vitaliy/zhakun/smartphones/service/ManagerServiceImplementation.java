package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Manager;
import com.vitaliy.zhakun.smartphones.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImplementation implements ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImplementation(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerById(Long id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if (optionalManager.isEmpty())
            throw new IllegalStateException("Manager with Id = " + id + " does not exist.");
        return optionalManager.get();
    }
    
    @Override
    public Manager addManager(Manager manager) {
        Optional<Manager> optionalManager = managerRepository.findById(manager.getId());
        if (optionalManager.isEmpty())
            throw new IllegalStateException("Manager with Id = " + manager.getId() + " is already exist in Database.");
        return managerRepository.save(manager);
    }

    @Override
    public List<Manager> addManagers(Iterable<Manager> managers) {
        return managerRepository.saveAll(managers);
    }

    @Override
    public Manager updateManager(Manager manager, Long id) {
        manager.setId(id);
        return managerRepository.save(manager);
    }

    @Override
    public void deleteManagerById(Long id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if (optionalManager.isEmpty())
            throw new IllegalStateException("Manager with Id = " + id + " does not exist.");
        else
            managerRepository.deleteById(id);

    }
}
