package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getAllManagers();

    Manager getManagerById(Long id);

    Manager addManager(Manager manager);

    List<Manager> addManagers(Iterable<Manager> managers);

    Manager updateManager(Manager manager, Long id);

    void deleteManagerById(Long id);

}
